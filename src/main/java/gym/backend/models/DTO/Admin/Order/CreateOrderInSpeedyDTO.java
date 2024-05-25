package gym.backend.models.DTO.Admin.Order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateOrderInSpeedyDTO {
    private Long officeID;
    private Double amountToBePayedByAdmin;
    private Double amountToBePayedByCustomer;
    private Long randomNumber;
    private Double totalWeight;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
}
