package gym.backend.init;

import gym.backend.init.initService.RequestService;
import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDataFromWebSite {

    private final ProductEntityRepository productEntityRepository;
    private final RequestService requestService;

    public void addEnemyPrices() {
        System.out.println("Start adding enemy prices from website to the DB... (This may take a few minutes.)");

        System.out.println("Model ids to scrape: "+ productEntityRepository.findProductEntitiesByDiscountedPriceNotNullAndIsAvailableTrue().size());

        for (ProductEntity productEntity : productEntityRepository.findProductEntitiesByDiscountedPriceNotNullAndIsAvailableTrue()) {
            productEntity.setEnemyPrice(extractEnemyPriceFromHTML(requestService.getHTMLDocumentByModelID(productEntity.getModelId()), productEntity.getModelId()));
            productEntityRepository.save(productEntity);
        }
        System.out.println("Scraping enemy prices has finished!");
    }

    private Double extractEnemyPriceFromHTML(ResponseEntity<String> responseEntity, String modelID) {
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
