package gym.backend.models.DTO.Admin.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressInfoDTO {
    private String country;
    private String town;
    private String officeAddress;
    private Long officeID;
}
