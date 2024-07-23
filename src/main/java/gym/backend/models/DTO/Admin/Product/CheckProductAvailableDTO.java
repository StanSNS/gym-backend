package gym.backend.models.DTO.Admin.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckProductAvailableDTO {
    private String brandId;
    private String modelId;
    private String selectedTasteID;
}
