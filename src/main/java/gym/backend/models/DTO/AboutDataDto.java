package gym.backend.models.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AboutDataDto {
    private Double savedMoney;
    private Integer soldProducts;
    private Integer satisfiedClients;
    private Integer deliveredProducts;
}
