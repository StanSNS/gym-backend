package gym.backend.models.json.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductJSON {
    private String model_id;
    private String brand_id;
    private String taste_id;
    private String taste_name;
    private String available;
    private String brand_name;
    private String product_name;
    private String s;
    private String regular_price;
}
