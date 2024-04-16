package gym.backend.models.json.ProductRequest.ProductData;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductsJSONFromBrand {
    private List<ProductJSONFromBrand> data;
}
