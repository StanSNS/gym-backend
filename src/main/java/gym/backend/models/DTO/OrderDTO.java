package gym.backend.models.DTO;

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

    private String country;
    private String town;
    private String address;
    private String additionalAddress;

    private String delivery;
    private String courier;
    private Double totalWeight;
    private Double totalAmount;
    private List<CartProductsDTO> cartItems;
}
