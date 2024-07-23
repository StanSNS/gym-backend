package gym.backend.models.DTO.Admin.Order;

import gym.backend.models.entity.BrandEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminProductDTO {
    private String modelId;
    private String brandID;
    private String name;
    private String image;
    private String weightKg;
    private Double regularPrice;
    private Double discountedPrice;
}
