package gym.backend.models.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class HomePageResponseDataDTO {
    private List<Map<String, Integer>> categories;
    private List<Map<String, Integer>> brands;
    private List<SellableProductDTO> products;

    public HomePageResponseDataDTO() {
        this.categories = new ArrayList<>();
        this.brands = new ArrayList<>();
        this.products = new ArrayList<>();
    }
}
