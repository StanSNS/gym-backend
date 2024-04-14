package gym.backend.service;

import gym.backend.models.DTO.CartProductsDTO;
import gym.backend.models.DTO.OrderDTO;
import gym.backend.models.enums.OrderStatus;
import gym.backend.models.entity.OrderEntity;
import gym.backend.models.entity.OrderProductEntity;
import gym.backend.repository.OrderEntityRepository;
import gym.backend.repository.OrderProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderEntityRepository orderEntityRepository;
    private final OrderProductEntityRepository orderProductEntityRepository;
    private final ModelMapper modelMapper;

    public void addOrder(OrderDTO orderDTO) {
        OrderEntity orderEntity = modelMapper.map(orderDTO, OrderEntity.class);
        orderEntity.setCartItems(new ArrayList<>());

        for (CartProductsDTO cartItemOrderDto : orderDTO.getCartItems()) {
            OrderProductEntity orderProductEntity = new OrderProductEntity();
            orderProductEntity.setQuantity(Integer.valueOf(cartItemOrderDto.getQuantity()));
            orderProductEntity.setModelId(cartItemOrderDto.getModelId());

            if(cartItemOrderDto.getSelectedTaste() != null){
                orderProductEntity.setSelectedTasteSilaId(cartItemOrderDto.getSelectedTaste().getSilaTasteID());
            }
            orderProductEntityRepository.save(orderProductEntity);
            orderEntity.getCartItems().add(orderProductEntity);
        }

        orderEntity.setOrderStatus(OrderStatus.PENDING);
        orderEntity.setDate(LocalDateTime.now());
        orderEntity.setRandomNumber(generateUniqueOrderNumber());
        orderEntityRepository.save(orderEntity);

    }

    private Long generateUniqueOrderNumber() {
        Random random = new Random();
        long randomNumber;
        boolean unique = false;

        do {
            randomNumber = 1000000000L + (long) (random.nextDouble() * 9000000000L);
            unique = !orderEntityRepository.existsByRandomNumber(randomNumber);
        } while (!unique);
        return randomNumber;
    }

}

