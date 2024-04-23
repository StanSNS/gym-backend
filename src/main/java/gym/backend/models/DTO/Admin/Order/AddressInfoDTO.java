package gym.backend.models.DTO.Admin.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressInfoDTO {
    private String country;
    private String town;
    private String address;
    private String additionalAddress;
    private String officeAddress;
}
