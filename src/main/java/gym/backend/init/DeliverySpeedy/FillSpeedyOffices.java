package gym.backend.init.DeliverySpeedy;

import com.google.gson.Gson;
import gym.backend.init.initService.RequestService;
import gym.backend.models.entity.AddressSpeedyEntity;
import gym.backend.models.entity.CitySpeedyEntity;
import gym.backend.models.json.DeliveryRequest.AddressSpeedyJSON;
import gym.backend.models.json.DeliveryRequest.CitiesSpeedyJSON;
import gym.backend.models.json.DeliveryRequest.CitySpeedyJSON;
import gym.backend.repository.AddressSpeedyEntityRepository;
import gym.backend.repository.CitySpeedyEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class FillSpeedyOffices {

    private final RequestService requestService;
    private final Gson gson;
    private final CitySpeedyEntityRepository citySpeedyEntityRepository;
    private final AddressSpeedyEntityRepository addressSpeedyEntityRepository;

    public void startInit() {
        CitiesSpeedyJSON citiesSpeedyJSON = gson.fromJson(requestService.getAllOfficesSpeedy(), CitiesSpeedyJSON.class);

        for (CitySpeedyJSON office : citiesSpeedyJSON.getOffices()) {
            AddressSpeedyJSON address = office.getAddress();

            StringBuilder modifiedCityNameSB = new StringBuilder();
            modifiedCityNameSB.append(address.getSiteType().toLowerCase()).append(" ");

            for (String singleWord : address.getSiteName().split("\\s+")) {
                String result = singleWord.substring(0, 1).toUpperCase() + singleWord.substring(1).toLowerCase();
                modifiedCityNameSB.append(result).append(" ");
            }

            String modifiedCityName = modifiedCityNameSB.toString();
            Optional<CitySpeedyEntity> optionalCitySpeedyEntity = citySpeedyEntityRepository.findByCityName(modifiedCityName);

            CitySpeedyEntity citySpeedyEntity;
            if (optionalCitySpeedyEntity.isEmpty()) {
                citySpeedyEntity = new CitySpeedyEntity();
                citySpeedyEntity.setSpeedyId(office.getId());
                citySpeedyEntity.setPostCode(address.getPostCode());
                citySpeedyEntity.setCityName(modifiedCityName);
                citySpeedyEntity.setAddresses(new ArrayList<>());
            } else {
                citySpeedyEntity = optionalCitySpeedyEntity.get();
            }

            AddressSpeedyEntity addressSpeedyEntity;

            if (!addressSpeedyEntityRepository.existsByFullAddress(address.getLocalAddressString())) {
                addressSpeedyEntity = new AddressSpeedyEntity();
                addressSpeedyEntity.setFullAddress(address.getLocalAddressString());
                addressSpeedyEntityRepository.save(addressSpeedyEntity);
                citySpeedyEntity.getAddresses().add(addressSpeedyEntity);
                citySpeedyEntityRepository.save(citySpeedyEntity);
            }

        }


    }
}
