package gym.backend.models.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartProductsDTO {
    private BrandDTO brandEntity;
    private String modelId;
    private String quantity;
    private TasteDTO selectedTaste;
    private String weightKg;
}
