package gym.backend.models.DTO.Order;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryPriceReqDTO {

    @Positive
    @NotNull
    private Integer officeID;

    @Positive
    @NotNull
    private Double amountWithoutDelivery;

    @NotNull
    private Double totalWeight;
}
