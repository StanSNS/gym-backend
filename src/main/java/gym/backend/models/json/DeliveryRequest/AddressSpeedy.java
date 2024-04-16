package gym.backend.models.json.DeliveryRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressSpeedy {
    private String siteName;
    private String siteType;
    private String postCode;
    private String localAddressString;
}
