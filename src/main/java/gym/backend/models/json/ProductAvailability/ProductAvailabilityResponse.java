package gym.backend.models.json.ProductAvailability;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductAvailabilityResponse {
    private List<ProductAvailabilityData> data;
    private Integer count;
}
