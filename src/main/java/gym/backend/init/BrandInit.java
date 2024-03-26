package gym.backend.init;

import com.google.gson.Gson;
import gym.backend.models.entity.BrandEntity;
import gym.backend.models.json.Brand.BrandJSON;
import gym.backend.repository.BrandEntityRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class BrandInit {

    @Value("${sila.bg}")
    private String SILA_BG_API_TOKEN;

    private final BrandEntityRepository brandEntityRepository;
    private final Gson gson;

    @PostConstruct
    public void brandsInit() {
        if (brandEntityRepository.count() > 0) {
            System.out.println("Brands already exists");
            return;
        }

        String brandURL = ("https://distro.silabg.com/api/v1/brand?api_token=" + SILA_BG_API_TOKEN);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(brandURL, HttpMethod.GET, requestEntity, String.class);

        if (responseEntity.getStatusCode().toString().startsWith("200")) {
            BrandJSON brandJSON = gson.fromJson(responseEntity.getBody(), BrandJSON.class);

            for (Map.Entry<String, String> stringStringEntry : brandJSON.getData().entrySet()) {
                brandEntityRepository.save(new BrandEntity(stringStringEntry.getKey(), stringStringEntry.getValue()));
            }
        }

    }
}
