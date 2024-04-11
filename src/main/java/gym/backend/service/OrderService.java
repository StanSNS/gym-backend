package gym.backend.service;

import gym.backend.models.DTO.CartProductsDTO;
import gym.backend.models.DTO.OrderDTO;
import gym.backend.models.entity.OrderEntity;
import gym.backend.models.entity.OrderProductEntity;
import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.OrderEntityRepository;
import gym.backend.repository.OrderProductEntityRepository;
import gym.backend.repository.ProductEntityRepository;
import gym.backend.repository.TasteEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
            orderProductEntityRepository.save(orderProductEntity);
            orderEntity.getCartItems().add(orderProductEntity);
        }
        orderEntityRepository.save(orderEntity);

    }

}

