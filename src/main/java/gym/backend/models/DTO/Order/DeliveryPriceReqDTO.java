package gym.backend.models.DTO.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryPriceReqDTO {
    private Long officeID;
    private Double amountWithoutDelivery;
    private Double totalWeight;
}
