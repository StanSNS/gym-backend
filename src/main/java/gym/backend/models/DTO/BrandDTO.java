package gym.backend.models.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String brandID;
}
