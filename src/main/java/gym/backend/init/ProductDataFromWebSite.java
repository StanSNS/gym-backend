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

    public void addEnemyPricesAndRating() {
        System.out.println("Start scraping enemy prices and ratings from website... (This may take a few minutes.)");

        for (ProductEntity productEntity : productEntityRepository.findProductEntitiesByDiscountedPriceNotNullAndIsAvailableTrue()) {
            extractEnemyPriceFromHTMLAndRatingDataFromHTML(productEntity);
        }
        System.out.println("Scraping has finished!");
    }

    private void extractEnemyPriceFromHTMLAndRatingDataFromHTML(ProductEntity productEntity) {
        ResponseEntity<String> responseEntity = requestService.getHTMLDocumentByModelID(productEntity.getModelId());
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
                            productEntity.setEnemyPrice(Double.parseDouble(value.trim()));
                        }
                    } else {
                        System.out.println("Value extraction failed for model ID: " + productEntity.getModelId());
                    }
                    break;
                }
            }

            Elements ratingValues = doc.getElementsByAttributeValue("itemprop", "ratingValue");
            for (Element span : ratingValues) {
                productEntity.setRatingValue(Double.parseDouble(span.text()));
            }

            Elements ratingCounts = doc.getElementsByAttributeValue("itemprop", "ratingCount");
            for (Element span : ratingCounts) {
                productEntity.setRatingCount(Integer.parseInt(span.text()));
            }

            productEntity.setOneStarRatingCount(0);
            productEntity.setTwoStarRatingCount(0);
            productEntity.setThreeStarRatingCount(0);
            productEntity.setFourStarRatingCount(0);
            productEntity.setFiveStarRatingCount(0);

            Element mainDiv = doc.selectFirst("div[style=float:left; margin-top:7px; margin-left:25px;]");
            if (mainDiv != null) {
                Elements divs = mainDiv.select("div");
                for (int i = 1; i < divs.size(); i++) {
                    Element div = divs.get(i);
                    String text = div.text();
                    if (text.contains("(") && text.contains(")")) {
                        int startIndex = text.indexOf("(") + 1;
                        int endIndex = text.indexOf(")");
                        int valueInsideBrackets = Integer.parseInt(text.substring(startIndex, endIndex));

                        switch (i) {
                            case 5 -> productEntity.setOneStarRatingCount(valueInsideBrackets);
                            case 4 -> productEntity.setTwoStarRatingCount(valueInsideBrackets);
                            case 3 -> productEntity.setThreeStarRatingCount(valueInsideBrackets);
                            case 2 -> productEntity.setFourStarRatingCount(valueInsideBrackets);
                            case 1 -> productEntity.setFiveStarRatingCount(valueInsideBrackets);
                        }
                    }
                }
            }
            productEntityRepository.save(productEntity);
        }
    }

}
