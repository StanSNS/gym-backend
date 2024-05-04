package gym.backend.models.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopProduct {
    private String name;
    private BrandDTO brandEntity;
    private String category;
    private String image;
    private String description;
    private String weightKg;
    private Double regularPrice;
    private Double discountedPrice;
    private Double ratingValue;
    private Integer ratingCount;

    public Double getDiscountedPrice() {
        return discountedPrice * 1.4;
    }
}
