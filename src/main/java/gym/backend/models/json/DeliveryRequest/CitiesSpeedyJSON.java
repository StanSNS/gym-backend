package gym.backend.models.json.DeliveryRequest;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CitiesSpeedyJSON {
    private List<CitySpeedyJSON> offices;
}
