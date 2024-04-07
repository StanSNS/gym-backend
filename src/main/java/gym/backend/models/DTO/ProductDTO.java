package gym.backend.models.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductDTO {
    private String name;
    private BrandDTO brandEntity;
    private String category;
    private String image;
    private String description;
    private Set<TasteDTO> taste;
    private Set<SizeDTO> size;
    private String weightKg;
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
