package gym.backend.models.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleProductDTO {
    private String sku;
    private String modelId;
    private BrandDTO brand;
    private String name;
    private String category;
    private String image;
    private Double discountedPrice;
    private Double regularPrice;
    private String weightKg;

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice * 1.4;
    }
}
