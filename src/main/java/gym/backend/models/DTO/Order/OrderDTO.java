package gym.backend.models.DTO.Order;

import gym.backend.models.DTO.CartProductsDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String town;
    private String postCode;
    private String officeAddress;
    private Double totalWeight;
    private Double totalAmount;
    private Double totalSaving;
    private Double deliveryPrice;
    private Integer productCount;
    private Long officeID;
    private List<CartProductsDTO> cartItems;
}
