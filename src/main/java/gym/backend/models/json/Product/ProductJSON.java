package gym.backend.models.json.Product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductJSON {
    private String id;
    private String model_id;
    private String name;
    private String brand;
    private String category;
    private String ean;
    private String image;
    private String label;
    private String description;
    private String weight_kg;
    private List<TasteJSON> taste;
    private List<SizeJSON> size;
}
