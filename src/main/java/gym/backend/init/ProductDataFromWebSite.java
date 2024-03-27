package gym.backend.init;

import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProductDataFromWebSite {

    private final ProductEntityRepository productEntityRepository;

    public void addEnemyPrices() {
        System.out.println("Start adding enemy prices from website to the DB... (This may take a few minutes.)");
        for (ProductEntity productEntity : productEntityRepository.findAll()) {
            productEntity.setEnemyPrice(extractEnemyPriceFromHTML(productEntity.getModelId()));
            productEntityRepository.save(productEntity);
        }
        System.out.println("Scraping enemy prices has finished!");
    }

    private Double extractEnemyPriceFromHTML(String modelID) {
        String brandURL = "https://www.silabg.com/bg/detail/id/" + modelID;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(brandURL, HttpMethod.GET, requestEntity, String.class);

        if (responseEntity.getStatusCode().toString().startsWith("200") && responseEntity.getBody() != null) {
            Document doc = Jsoup.parse(responseEntity.getBody());
            Elements scriptElements = doc.getElementsByTag("script");

            for (Element script : scriptElements) {
                String scriptText = script.html();
                if (scriptText.contains("gtag(\"event\", \"add_to_cart\"")) {
                    int startIndex = scriptText.indexOf("value:") + "value:".length();
                    int endIndex = scriptText.indexOf(",", startIndex);
                    if (endIndex != -1) {
                        String value = scriptText.substring(startIndex, endIndex);
                        if (value.trim().contains(".")) {
                            return Double.parseDouble(value.trim());
                        }
                    } else {
                        System.out.println("Value extraction failed for model ID: " + modelID);
                    }
                    break;
                }
            }
        }
        return null;
    }

}
