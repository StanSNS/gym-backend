package gym.backend.models.DTO.Order.SpeedyApi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DeliveryPriceMainResErrorDTO {
    public List<Calculation> calculations;

    @Getter
    @Setter
    @ToString
    public static class Calculation {
        public int serviceId;
        public Error error;

        @Getter
        @Setter
        @ToString
        public static class Error {
            public String context;
            public String message;
            public String id;
            public int code;
        }
    }
}
