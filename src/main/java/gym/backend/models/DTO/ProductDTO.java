package gym.backend.models.DTO;

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

    public Double getDiscountedPrice() {
        return discountedPrice * 1.3;
    }
}
