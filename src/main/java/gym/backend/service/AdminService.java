package gym.backend.service;

import com.google.gson.Gson;
import gym.backend.exception.DataValidationException;
import gym.backend.exception.InternalErrorException;
import gym.backend.exception.ResourceNotFoundException;
import gym.backend.models.DTO.Admin.Auth.JwtAuthResponseDTO;
import gym.backend.models.DTO.Admin.Auth.LoginDTO;
import gym.backend.models.DTO.Admin.Order.*;
import gym.backend.models.DTO.Order.SpeedyApi.DeliveryPriceMainReqDTO;
import gym.backend.models.entity.*;
import gym.backend.models.enums.OrderStatus;
import gym.backend.repository.*;
import gym.backend.security.JwtTokenProvider;
import gym.backend.utils.ValidationUtil;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class AdminService {
    @Value("${speedy.api.username}")
    private String SPEEDY_API_USERNAME;
    @Value("${speedy.api.password}")
    private String SPEEDY_API_PASSWORD;

    private final OrderEntityRepository orderEntityRepository;
    private final ProductEntityRepository productEntityRepository;
    private final TasteEntityRepository tasteEntityRepository;
    private final EmailService emailService;
    private final AdminEntityRepository adminEntityRepository;
    private final ValidationUtil validationUtil;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final AddressSpeedyEntityRepository addressSpeedyEntityRepository;
    private final Gson gson;

    public List<AdminOrderDTO> getAllOrdersForAdminPage() {
        List<AdminOrderDTO> adminOrderDTOToReturn = new ArrayList<>();

        for (OrderEntity orderEntity : orderEntityRepository.findAll()) {
            AdminOrderDTO adminOrderDTO = new AdminOrderDTO();

            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setFirstName(orderEntity.getFirstName());
            userInfoDTO.setLastName(orderEntity.getLastName());
            userInfoDTO.setEmail(orderEntity.getEmail());
            userInfoDTO.setPhone(orderEntity.getPhone());
            adminOrderDTO.setUserInfo(userInfoDTO);

            Optional<AddressSpeedyEntity> byFullAddress = addressSpeedyEntityRepository.findByFullAddress(orderEntity.getOfficeAddress());
            if (byFullAddress.isEmpty()) {
                throw new ResourceNotFoundException();
            }

            AddressInfoDTO addressInfoDTO = new AddressInfoDTO();
            addressInfoDTO.setCountry(orderEntity.getCountry());
            addressInfoDTO.setTown(orderEntity.getTown());
            addressInfoDTO.setOfficeAddress(orderEntity.getOfficeAddress());
            adminOrderDTO.setAddressInfo(addressInfoDTO);
            addressInfoDTO.setOfficeID(byFullAddress.get().getOfficeID());

            double amountAdminToPay = 0;

            adminOrderDTO.setProductOrders(new ArrayList<>());
            for (OrderProductEntity cartItem : orderEntity.getCartItems()) {
                AdminShoppingCartDTO adminShoppingCartDTO = new AdminShoppingCartDTO();
                ProductEntity productEntity = productEntityRepository.findProductEntityByModelId(cartItem.getModelId());

                AdminProductDTO adminProductDTO = new AdminProductDTO();
                adminProductDTO.setModelId(productEntity.getModelId());
                adminProductDTO.setName(productEntity.getName());
                adminProductDTO.setImage(productEntity.getImage());
                adminProductDTO.setWeightKg(productEntity.getWeightKg());
                adminProductDTO.setRegularPrice(productEntity.getRegularPrice());
                adminProductDTO.setDiscountedPrice(productEntity.getDiscountedPrice() * 1.4);

                adminShoppingCartDTO.setAdminProductDTO(adminProductDTO);
                adminShoppingCartDTO.setQuantity(cartItem.getQuantity());

                if (cartItem.getSelectedTasteSilaId() != null) {
                    Optional<TasteEntity> tasteEntity = tasteEntityRepository.findTasteEntityBySilaTasteID(cartItem.getSelectedTasteSilaId());
                    if (tasteEntity.isEmpty()) {
                        throw new ResourceNotFoundException();
                    }
                    adminShoppingCartDTO.setSelectedTaste(tasteEntity.get().getName());
                } else {
                    adminShoppingCartDTO.setSelectedTaste("");
                }

                adminOrderDTO.getProductOrders().add(adminShoppingCartDTO);
                amountAdminToPay += productEntity.getDiscountedPrice() * cartItem.getQuantity();
            }

            adminOrderDTO.setTotalWeight(orderEntity.getTotalWeight());
            adminOrderDTO.setAmountToBePayedByCustomer(orderEntity.getTotalAmount());
            adminOrderDTO.setOrderStatus(orderEntity.getOrderStatus().name());
            adminOrderDTO.setAmountToBePayedByAdmin(amountAdminToPay);
            adminOrderDTO.setCompanyProfit(adminOrderDTO.getAmountToBePayedByCustomer() - adminOrderDTO.getAmountToBePayedByAdmin());
            adminOrderDTO.setDate(orderEntity.getDate());
            adminOrderDTO.setRandomNumber(orderEntity.getRandomNumber());
            adminOrderDTO.setSpeedyDeliveryId(orderEntity.getSpeedyDeliveryId());

            adminOrderDTOToReturn.add(adminOrderDTO);
        }

        return adminOrderDTOToReturn;
    }

    public void modifyOrderStatus(String status, Long randomNumber) throws MessagingException {
        OrderEntity orderEntity = orderEntityRepository.findByRandomNumber(randomNumber);
        if (orderEntity == null) {
            throw new ResourceNotFoundException();
        }

        switch (status) {
            case "PENDING" -> orderEntity.setOrderStatus(OrderStatus.PENDING);
            case "APPROVED" -> orderEntity.setOrderStatus(OrderStatus.APPROVED);
            case "IN_DELIVERY" -> orderEntity.setOrderStatus(OrderStatus.IN_DELIVERY);
            case "COMPLETED" -> orderEntity.setOrderStatus(OrderStatus.COMPLETED);
            case "CANCELED" -> orderEntity.setOrderStatus(OrderStatus.CANCELED);
            case "RETURNED" -> orderEntity.setOrderStatus(OrderStatus.RETURNED);
            default -> throw new ResourceNotFoundException();
        }

        orderEntityRepository.save(orderEntity);

        emailService.generateHTMLContentAndSendEmail(orderEntity);
    }

    @Transactional
    public JwtAuthResponseDTO login(LoginDTO loginDto) {
        if (!validationUtil.isValid(loginDto)) {
            throw new DataValidationException();
        }
        AdminEntity adminEntity = null;

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Optional<AdminEntity> userEntityOptional = adminEntityRepository.findByUsername(loginDto.getUsername());

        String token = "";
        JwtAuthResponseDTO jwtAuthResponse = new JwtAuthResponseDTO();

        if (userEntityOptional.isPresent()) {
            adminEntity = userEntityOptional.get();
            Set<RoleEntity> roles = adminEntity.getRoles();

            if (adminEntity.getJwtToken() == null || adminEntity.getJwtToken().isEmpty() || !jwtTokenProvider.validateToken(adminEntity.getJwtToken())) {
                token = jwtTokenProvider.generateToken(authentication);
                adminEntity.setJwtToken(token);
                adminEntityRepository.save(adminEntity);
            } else {
                token = adminEntity.getJwtToken();
            }
            if (!roles.isEmpty()) {
                jwtAuthResponse.setRole(roles.stream().map(RoleEntity::getName).collect(Collectors.toSet()));
            }
        }
        if (token.isEmpty()) {
            throw new InternalErrorException();
        }
        jwtAuthResponse.setAccessToken(token);
        jwtAuthResponse.setExpirationDate(jwtTokenProvider.getJwtExpirationDate());

        if (!validationUtil.isValid(jwtAuthResponse)) {
            throw new DataValidationException();
        }

        return jwtAuthResponse;
    }

    public void createSpeedyOrderAPI(CreateOrderInSpeedyDTO createOrderInSpeedyDTO) throws MessagingException {
        OrderEntity orderEntity = orderEntityRepository.findByRandomNumber(createOrderInSpeedyDTO.getRandomNumber());
        if (orderEntity == null) {
            throw new ResourceNotFoundException();
        }

        if (!orderEntity.getOrderStatus().equals(OrderStatus.PENDING)) {
            throw new DataValidationException();
        }

        CreateOrderSpeedyApiReqDTO createOrderSpeedyApiReqDTO = buildCreateOrderSpeedyBody(createOrderInSpeedyDTO);

        String productsURL = "https://api.speedy.bg/v1/shipment";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<CreateOrderSpeedyApiReqDTO> requestEntity = new HttpEntity<>(createOrderSpeedyApiReqDTO, headers);

        ResponseEntity<String> exchange = restTemplate.exchange(productsURL, HttpMethod.POST, requestEntity, String.class);

        CreateOrderSpeedyApiResDTO createOrderSpeedyApiResDTO = gson.fromJson(exchange.getBody(), CreateOrderSpeedyApiResDTO.class);

        orderEntity.setSpeedyDeliveryId(createOrderSpeedyApiResDTO.getId());
        orderEntity.setPickupDate(createOrderSpeedyApiResDTO.getPickupDate());
        orderEntity.setDeliveryDeadline(createOrderSpeedyApiResDTO.getDeliveryDeadline());
        orderEntity.setOrderStatus(OrderStatus.APPROVED);

        orderEntityRepository.save(orderEntity);

        emailService.generateHTMLContentAndSendEmail(orderEntity);
    }

    private CreateOrderSpeedyApiReqDTO buildCreateOrderSpeedyBody(CreateOrderInSpeedyDTO createOrderInSpeedyDTO) {
        Double amountToBePayedByCustomer = createOrderInSpeedyDTO.getAmountToBePayedByCustomer();
        Double totalWeight = createOrderInSpeedyDTO.getTotalWeight();
        String phone = createOrderInSpeedyDTO.getPhone();
        String name = createOrderInSpeedyDTO.getFirstName().trim() + " " + createOrderInSpeedyDTO.getLastName().trim();
        String email = createOrderInSpeedyDTO.getEmail();
        Long officeID = createOrderInSpeedyDTO.getOfficeID();

        CreateOrderSpeedyApiReqDTO createOrderSpeedyApiReqDTO = new CreateOrderSpeedyApiReqDTO();
        createOrderSpeedyApiReqDTO.setUserName(SPEEDY_API_USERNAME);
        createOrderSpeedyApiReqDTO.setPassword(SPEEDY_API_PASSWORD);
        createOrderSpeedyApiReqDTO.getService().getAdditionalServices().getDeclaredValue().setAmount(amountToBePayedByCustomer);
        createOrderSpeedyApiReqDTO.getContent().setTotalWeight(totalWeight);

        createOrderSpeedyApiReqDTO.getSender().getPhone1().setNumber("0888112233");

        createOrderSpeedyApiReqDTO.getRecipient().getPhone1().setNumber(phone);
        createOrderSpeedyApiReqDTO.getRecipient().setClientName(name);
        createOrderSpeedyApiReqDTO.getRecipient().setEmail(email);
        createOrderSpeedyApiReqDTO.getRecipient().setPickupOfficeId(officeID);


        return createOrderSpeedyApiReqDTO;
    }

}
