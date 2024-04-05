package gym.backend.models.DTO;

import jakarta.persistence.Column;
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
    private Double ratingValue;
    private Integer ratingCount;
    private Double enemyPrice;
    private Double reducedTotalAmountPercentage;
    private String sku;
    private String modelId;

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice * 1.3;
    }

    public void setDescription(String description) {
        description.replaceFirst("<span\\s+style=\"[^\"]*\"[^>]*>", "")
                .replaceFirst("<h1>", "")
                .replaceFirst("</h1>", "");

        int length = description.length();

        if (length < 200) {
            this.description = description.substring(0, length);
        } else {
            this.description = description.substring(0, 200);
        }

    }
}
