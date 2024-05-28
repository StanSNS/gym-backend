package gym.backend.models.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartProductsDTO {
    private BrandDTO brandEntity;

    @NotBlank
    private String modelId;

    @NotBlank
    @Positive
    private String quantity;

    private TasteDTO selectedTaste;

    @NotBlank
    private String weightKg;
}
