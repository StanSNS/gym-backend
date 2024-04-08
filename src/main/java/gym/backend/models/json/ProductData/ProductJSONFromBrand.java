package gym.backend.models.json.ProductData;

import gym.backend.models.json.Taste.TasteJSON;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductJSONFromBrand {
    private String id;
    private String model_id;
    private String name;
    private String brand;
    private String category;
    private String image;
    private String label;
    private String description;
    private List<TasteJSON> taste;
    private String weight_kg;
}
