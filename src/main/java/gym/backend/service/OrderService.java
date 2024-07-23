package gym.backend.service;

import com.google.gson.Gson;
import gym.backend.models.DTO.CartProductsDTO;
import gym.backend.models.DTO.Order.DeliveryPriceReqDTO;
import gym.backend.models.DTO.Order.OrderDTO;
import gym.backend.models.DTO.Order.RetrieveOrderDTO;
import gym.backend.models.DTO.Order.SpeedyApi.DeliveryPriceMainReqDTO;
import gym.backend.models.DTO.Order.SpeedyApi.DeliveryPriceMainResDTO;
import gym.backend.models.DTO.Order.SpeedyApi.DeliveryPriceMainResErrorDTO;
import gym.backend.models.DTO.SpeedyOffices.CitySpeedyDTO;
import gym.backend.models.entity.OrderEntity;
import gym.backend.models.entity.OrderProductEntity;
import gym.backend.models.enums.OrderStatus;
import gym.backend.repository.AddressSpeedyEntityRepository;
import gym.backend.repository.CitySpeedyEntityRepository;
import gym.backend.repository.OrderEntityRepository;
import gym.backend.repository.OrderProductEntityRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final DataSourceTransactionManagerAutoConfiguration dataSourceTransactionManagerAutoConfiguration;
    @Value("${speedy.api.username}")
    private String SPEEDY_API_USERNAME;
    @Value("${speedy.api.password}")
    private String SPEEDY_API_PASSWORD;

    private final OrderEntityRepository orderEntityRepository;
    private final OrderProductEntityRepository orderProductEntityRepository;
    private final ModelMapper modelMapper;
    private final CitySpeedyEntityRepository citySpeedyEntityRepository;
    private final AddressSpeedyEntityRepository addressSpeedyEntityRepository;
    private final EmailService emailService;
    private final Gson gson;

    public Long addOrder(OrderDTO orderDTO) throws MessagingException {
        OrderEntity orderEntity = modelMapper.map(orderDTO, OrderEntity.class);
        orderEntity.setCartItems(new ArrayList<>());
        orderEntity.setCountry("България");

        for (CartProductsDTO cartItemOrderDto : orderDTO.getCartItems()) {
            OrderProductEntity orderProductEntity = new OrderProductEntity();
            orderProductEntity.setQuantity(Integer.valueOf(cartItemOrderDto.getQuantity()));
            orderProductEntity.setModelId(cartItemOrderDto.getModelId());

            if (cartItemOrderDto.getSelectedTaste() != null) {
                orderProductEntity.setSelectedTasteSilaId(cartItemOrderDto.getSelectedTaste().getSilaTasteID());
            }
            orderProductEntityRepository.save(orderProductEntity);
            orderEntity.getCartItems().add(orderProductEntity);
        }

        orderEntity.setOrderStatus(OrderStatus.PENDING);
        orderEntity.setDate(LocalDateTime.now());

        Long randomOrderNumber = generateUniqueOrderNumber();

        orderEntity.setRandomNumber(randomOrderNumber);
        orderEntity.setIsUserCalled(false);
        orderEntityRepository.save(orderEntity);

        emailService.generateHTMLContentAndSendEmail(orderEntity);

        return randomOrderNumber;
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

    @Cacheable(value = "allSpeedyAddresses")
    public List<CitySpeedyDTO> getAllSpeedyAddresses() {
        return citySpeedyEntityRepository
                .findAll()
                .stream()
                .map(citySpeedyEntity ->
                        modelMapper.map(citySpeedyEntity, CitySpeedyDTO.class))
                .collect(Collectors.toList());
    }

    public ResponseEntity<String> recoverOrdersAndSendEmail(String email) throws MessagingException {
        List<RetrieveOrderDTO> ordersByEmail = orderEntityRepository.findAllByEmail(email).stream().map(orderEntity -> modelMapper.map(orderEntity, RetrieveOrderDTO.class)).collect(Collectors.toList());
        if (ordersByEmail.size() <= 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        emailService.generateAllOrdersByEmail(ordersByEmail, email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<String> findOrderAndSendEmail(Long number) throws MessagingException {
        OrderEntity orderEntity = orderEntityRepository.findByRandomNumber(number);
        if (orderEntity == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        emailService.generateHTMLContentAndSendEmail(orderEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> getDeliveryPrice(DeliveryPriceReqDTO deliveryPriceDTOReq) {
        String productsURL = "https://api.speedy.bg/v1/calculate/";

        double totalWeight;

        if (deliveryPriceDTOReq.getTotalWeight() == 0.0) {
            totalWeight = 0.100;
        } else {
            totalWeight = deliveryPriceDTOReq.getTotalWeight();
        }

        DeliveryPriceMainReqDTO deliveryPriceMainReq = new DeliveryPriceMainReqDTO();
        deliveryPriceMainReq.setUserName(SPEEDY_API_USERNAME);
        deliveryPriceMainReq.setPassword(SPEEDY_API_PASSWORD);
        deliveryPriceMainReq.getRecipient().setPickupOfficeId(deliveryPriceDTOReq.getOfficeID());
        deliveryPriceMainReq.getContent().setTotalWeight(totalWeight);
        deliveryPriceMainReq.getService().getAdditionalServices().getDeclaredValue().setAmount(deliveryPriceDTOReq.getAmountWithoutDelivery());

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<DeliveryPriceMainReqDTO> requestEntity = new HttpEntity<>(deliveryPriceMainReq, headers);

        ResponseEntity<String> exchange = restTemplate.exchange(productsURL, HttpMethod.POST, requestEntity, String.class);

        Object responseBodyObject = gson.fromJson(exchange.getBody(), Object.class);

        DeliveryPriceMainResDTO deliveryPriceMainResDTO = modelMapper.map(responseBodyObject, DeliveryPriceMainResDTO.class);

        if (deliveryPriceMainResDTO.getCalculations().get(0).getPrice() == null) {
            return new ResponseEntity<>(modelMapper.map(responseBodyObject, DeliveryPriceMainResErrorDTO.class), HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
        return new ResponseEntity<>(deliveryPriceMainResDTO, HttpStatus.OK);
    }
}