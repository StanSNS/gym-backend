package gym.backend.models.DTO.SpeedyOffices;

import gym.backend.models.entity.AddressSpeedyEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CitySpeedyDTO {
    private String cityName;
    private String postCode;
    private List<AddressSpeedyDTO> addresses;
}
