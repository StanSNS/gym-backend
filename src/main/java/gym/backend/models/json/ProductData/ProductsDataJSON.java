package gym.backend.models.json.ProductData;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductsDataJSON {
    private List<ProductDataJSON> data;
}
