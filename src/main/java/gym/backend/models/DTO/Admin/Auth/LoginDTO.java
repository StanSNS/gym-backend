package gym.backend.models.DTO.Admin.Auth;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class LoginDTO {
    private String username;
    private String password;
}
