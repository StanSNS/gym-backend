package gym.backend.models.DTO.Order;

import gym.backend.models.DTO.CartProductsDTO;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String town;

    @NotBlank
    private String postCode;

    @NotBlank
    private String officeAddress;

    @NotNull
    private Double totalWeight;

    @NotNull
    private Double totalAmount;

    @NotNull
    private Double totalSaving;

    @NotNull
    private Double deliveryPrice;

    @NotNull
    private Integer productCount;

    @NotNull
    private Long officeID;

    @NotNull
    private List<CartProductsDTO> cartItems;
}
