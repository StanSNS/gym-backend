package gym.backend.models.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SellableProductDTO {
    private BrandDTO brandEntity;
    private String category;
    private String description;
    private Double discountedPrice;
    private String image;
    private String name;
    private List<SizeDTO> size;
    private List<TasteDTO> taste;
    private String weightKg;

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice * 1.5;
    }

    public void setDescription(String description) {
        this.description = description.substring(0, 200);
    }
}
