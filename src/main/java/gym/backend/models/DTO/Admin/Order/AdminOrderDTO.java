package gym.backend.models.DTO.Admin.Order;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AdminOrderDTO {
    private UserInfoDTO userInfo;
    private AddressInfoDTO addressInfo;
    private List<AdminShoppingCartDTO> productOrders;
    private Double totalWeight;
    private Double amountToBePayedByCustomer;
    private Double amountToBePayedByAdmin;
    private Double companyProfit;
    private String orderStatus;
    private LocalDateTime date;
    private String speedyDeliveryId;
    private Long randomNumber;
    private Boolean isUserCalled;
}
