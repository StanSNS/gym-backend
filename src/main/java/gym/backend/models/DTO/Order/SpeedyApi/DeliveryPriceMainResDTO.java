package gym.backend.models.DTO.Order.SpeedyApi;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeliveryPriceMainResDTO {
    private List<Calculation> calculations;

    @Getter
    @Setter
    public static class Calculation {
        private Price price;

        @Getter
        @Setter
        public static class Price {
            private double total;
        }
    }

}



