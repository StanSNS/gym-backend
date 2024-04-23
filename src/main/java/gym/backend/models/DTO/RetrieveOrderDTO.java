package gym.backend.models.DTO;

import gym.backend.models.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RetrieveOrderDTO {
    private Long randomNumber;
    private LocalDateTime date;
    private Double totalAmount;
    private OrderStatus orderStatus;
}
