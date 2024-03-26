package gym.backend.init;

import com.google.gson.Gson;
import gym.backend.models.entity.BrandEntity;
import gym.backend.models.entity.SizeEntity;
import gym.backend.models.entity.TasteEntity;
import gym.backend.models.json.Size.SizeJSON;
import gym.backend.models.json.Size.SizeJSONData;
import gym.backend.models.json.Size.SizeJSONList;
import gym.backend.models.json.Taste.TasteJSON;
import gym.backend.models.json.Taste.TasteJSONData;
import gym.backend.models.json.Taste.TasteJSONList;
import gym.backend.repository.BrandEntityRepository;
import gym.backend.repository.SizeEntityRepository;
import gym.backend.repository.TasteEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class TasteAndSizeInit {

    @Value("${sila.bg}")
    private String SILA_BG_API_TOKEN;

    private final BrandEntityRepository brandEntityRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final TasteEntityRepository tasteEntityRepository;
    private final SizeEntityRepository sizeEntityRepository;

    public void saveBothData() {
        for (int i = 0; i < 3; i++) {
            for (BrandEntity brandEntity : brandEntityRepository.findAll()) {
                if (!brandEntity.getBrandID().equals("169")) {
                    initTestesByBrandID(brandEntity.getBrandID());
                    initSizesByBrandID(brandEntity.getBrandID());
                }
            }
        }

        System.out.println("Total tastes pushed: " + tasteEntityRepository.count());
        System.out.println("Total sizes pushed: " + sizeEntityRepository.count());
    }

    private void initTestesByBrandID(String brandID) {
        ResponseEntity<String> stringResponseEntity = sendRequest(brandID);

        if (stringResponseEntity.getStatusCode().toString().startsWith("200")) {
            TasteJSONData tasteJSONData = gson.fromJson(stringResponseEntity.getBody(), TasteJSONData.class);

            for (TasteJSONList singleProductData : tasteJSONData.getData()) {
                for (TasteJSON tasteJSON : singleProductData.getTaste()) {
                    TasteEntity tasteEntity = modelMapper.map(tasteJSON, TasteEntity.class);

                    if (!tasteEntityRepository.existsByTasteId(tasteEntity.getTasteId())) {
                        tasteEntityRepository.save(tasteEntity);
                    }
                }
            }
        }
    }

    private void initSizesByBrandID(String brandID) {
        ResponseEntity<String> stringResponseEntity = sendRequest(brandID);

        if (stringResponseEntity.getStatusCode().toString().startsWith("200")) {
            SizeJSONData sizeJSONData = gson.fromJson(stringResponseEntity.getBody(), SizeJSONData.class);

            for (SizeJSONList singleProductData : sizeJSONData.getData()) {
                for (SizeJSON sizeJSON : singleProductData.getSize()) {
                    SizeEntity sizeEntity = modelMapper.map(sizeJSON, SizeEntity.class);

                    if (!sizeEntityRepository.existsBySizeId(sizeEntity.getSizeId())) {
                        sizeEntityRepository.save(sizeEntity);
                    }
                }
            }

        }
    }


    private ResponseEntity<String> sendRequest(String brandID) {
        String productsURL = "https://distro.silabg.com/api/v1/brandfeed?api_token=" + SILA_BG_API_TOKEN;
        String jsonData = "{\"brand_id\": \"" + brandID + "\"}";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonData, headers);

        return restTemplate.exchange(productsURL, HttpMethod.POST, requestEntity, String.class);
    }


}
