package gym.backend.models.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SingleProduct {
    private String name;
    private BrandDTO brandEntity;
    private String category;
    private String image;
    private String description;
    private Set<TasteDTO> taste;
    private String weightKg;
    private String modelId;
    private Double regularPrice;
    private Double discountedPrice;
    private Double ratingValue;
    private Integer ratingCount;
    private Integer oneStarRatingCount;
    private Integer twoStarRatingCount;
    private Integer threeStarRatingCount;
    private Integer fourStarRatingCount;
    private Integer fiveStarRatingCount;

    public Double getDiscountedPrice() {
        return discountedPrice * 1.3;
    }
}
