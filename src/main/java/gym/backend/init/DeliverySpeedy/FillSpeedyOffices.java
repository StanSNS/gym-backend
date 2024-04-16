package gym.backend.init.DeliverySpeedy;

import com.google.gson.Gson;
import gym.backend.exception.ResourceNotFoundException;
import gym.backend.init.initService.RequestService;
import gym.backend.models.entity.CitySpeedyEntity;
import gym.backend.models.json.DeliveryRequest.AddressSpeedy;
import gym.backend.models.json.DeliveryRequest.CitiesSpeedy;
import gym.backend.models.json.DeliveryRequest.CitySpeedy;
import gym.backend.repository.CitySpeedyEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FillSpeedyOffices {

    private final RequestService requestService;
    private final Gson gson;
    private final CitySpeedyEntityRepository citySpeedyEntityRepository;

    public void fillAddressesAndTowns() {
        CitiesSpeedy citiesSpeedyBG = gson.fromJson(requestService.getAllOfficesSpeedyBG(), CitiesSpeedy.class);

        for (CitySpeedy office : citiesSpeedyBG.getOffices()) {
            AddressSpeedy address = office.getAddress();

            CitySpeedyEntity citySpeedyEntity = new CitySpeedyEntity();
            citySpeedyEntity.setSiteNameBg(address.getSiteName());
            citySpeedyEntity.setSiteTypeBg(address.getSiteType());
            citySpeedyEntity.setPostCode(address.getPostCode());
            citySpeedyEntity.setAddressBG(address.getLocalAddressString());
            citySpeedyEntity.setSpeedyId(office.getId());
            citySpeedyEntityRepository.save(citySpeedyEntity);
        }

        CitiesSpeedy citiesSpeedyEN = gson.fromJson(requestService.getAllOfficesSpeedyEN(), CitiesSpeedy.class);

        for (CitySpeedy office : citiesSpeedyEN.getOffices()) {
            AddressSpeedy address = office.getAddress();

            CitySpeedyEntity citySpeedyEntity = citySpeedyEntityRepository.findBySpeedyId(office.getId());
            if (citySpeedyEntity == null) {
                throw new ResourceNotFoundException();
            }
            citySpeedyEntity.setSiteNameEn(address.getSiteName());
            citySpeedyEntity.setSiteTypeEn(address.getSiteType());
            citySpeedyEntity.setAddressEN(address.getLocalAddressString());
            citySpeedyEntityRepository.save(citySpeedyEntity);
        }

    }
}
