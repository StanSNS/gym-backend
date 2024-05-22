package gym.backend.service;

import gym.backend.exception.DataValidationException;
import gym.backend.exception.InternalErrorException;
import gym.backend.exception.ResourceNotFoundException;
import gym.backend.models.DTO.Admin.Auth.JwtAuthResponseDTO;
import gym.backend.models.DTO.Admin.Auth.LoginDTO;
import gym.backend.models.DTO.Admin.Order.*;
import gym.backend.models.entity.*;
import gym.backend.models.enums.OrderStatus;
import gym.backend.repository.AdminEntityRepository;
import gym.backend.repository.OrderEntityRepository;
import gym.backend.repository.ProductEntityRepository;
import gym.backend.repository.TasteEntityRepository;
import gym.backend.security.JwtTokenProvider;
import gym.backend.utils.ValidationUtil;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class AdminService {

    private final OrderEntityRepository orderEntityRepository;
    private final ProductEntityRepository productEntityRepository;
    private final TasteEntityRepository tasteEntityRepository;
    private final EmailService emailService;
    private final AdminEntityRepository adminEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private final ValidationUtil validationUtil;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

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

            AddressInfoDTO addressInfoDTO = new AddressInfoDTO();
            addressInfoDTO.setCountry(orderEntity.getCountry());
            addressInfoDTO.setTown(orderEntity.getTown());
            addressInfoDTO.setOfficeAddress(orderEntity.getOfficeAddress());
            addressInfoDTO.setAddress(orderEntity.getAddress());
            addressInfoDTO.setAdditionalAddress(orderEntity.getAdditionalAddress());
            adminOrderDTO.setAddressInfo(addressInfoDTO);

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

            adminOrderDTO.setDelivery(orderEntity.getDelivery());
            adminOrderDTO.setCourier(orderEntity.getCourier());
            adminOrderDTO.setTotalWeight(orderEntity.getTotalWeight());
            adminOrderDTO.setAmountToBePayedByCustomer(orderEntity.getTotalAmount());
            adminOrderDTO.setOrderStatus(orderEntity.getOrderStatus().name());
            adminOrderDTO.setAmountToBePayedByAdmin(amountAdminToPay);
            adminOrderDTO.setCompanyProfit(adminOrderDTO.getAmountToBePayedByCustomer() - adminOrderDTO.getAmountToBePayedByAdmin());
            adminOrderDTO.setDate(orderEntity.getDate());
            adminOrderDTO.setRandomNumber(orderEntity.getRandomNumber());

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
}
