package gym.backend.models.DTO.Admin.Auth;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class JwtAuthResponseDTO {

    @NotNull
    private String accessToken;

    @NotNull
    private Set<String> role;

    @NotNull
    private Long expirationDate;
}