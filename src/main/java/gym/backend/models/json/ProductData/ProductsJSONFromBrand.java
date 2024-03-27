package gym.backend.models.json.ProductData;

import gym.backend.models.json.Size.SizeJSON;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductsJSONFromBrand {
    private List<ProductJSONFromBrand> data;
}
