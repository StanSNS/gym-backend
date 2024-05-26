package gym.backend.models.DTO.Admin.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderSpeedyApiResDTO {
    private String id;
    private String pickupDate;
    private String deliveryDeadline;
}
