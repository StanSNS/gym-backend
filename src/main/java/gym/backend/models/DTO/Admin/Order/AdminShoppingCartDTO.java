package gym.backend.models.DTO.Admin.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminShoppingCartDTO {
    private AdminProductDTO adminProductDTO;
    private Integer quantity;
    private String selectedTaste;
}
