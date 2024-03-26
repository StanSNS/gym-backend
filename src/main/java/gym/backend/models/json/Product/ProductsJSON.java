package gym.backend.models.json.Product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductsJSON {
    private List<ProductJSON> data;
}
