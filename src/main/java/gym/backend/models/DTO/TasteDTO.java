package gym.backend.models.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TasteDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String colors;

    @NotBlank
    private String colorNames;

    @NotBlank
    private String silaTasteID;
}
