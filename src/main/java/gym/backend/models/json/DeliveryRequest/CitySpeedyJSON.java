package gym.backend.models.json.DeliveryRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CitySpeedyJSON {
    private Long id;
    private AddressSpeedyJSON address;
}
