package gym.backend.init.Products;

import gym.backend.exception.InitDataException;
import gym.backend.init.initService.RequestService;
import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static gym.backend.utils.TimeUtils.convertMsToTime;

@Component
@RequiredArgsConstructor
public class ProductDataFromWebSite {

    private final ProductEntityRepository productEntityRepository;
    private final RequestService requestService;

    @CacheEvict(value = "allSellableProducts", allEntries = true)
    public void startInit() {
        ArrayList<ProductEntity> entitiesToSave = new ArrayList<>();
        for (ProductEntity currentProductEntity : productEntityRepository.findProductEntitiesByDiscountedPriceNotNullAndIsAvailableTrue()) {
            ProductEntity modifiedProductEntity = extractEnemyPriceFromHTMLAndRatingDataFromHTML(currentProductEntity);
            if (modifiedProductEntity == null) {
                throw new InitDataException("product-data-details-web-execute");
            }

            entitiesToSave.add(modifiedProductEntity);
        }
        productEntityRepository.saveAll(entitiesToSave);
    }

    private ProductEntity extractEnemyPriceFromHTMLAndRatingDataFromHTML(ProductEntity productEntity) {
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
                        String value = scriptText.substring(startIndex, endIndex).trim();
                        try {
                            productEntity.setEnemyPrice(Double.parseDouble(value));
                        } catch (NumberFormatException ignored) {

                        }
                    }
                    break;
                }
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
            productEntity.setRatingCount(0);

            int ratingCount = productEntity.getOneStarRatingCount() +
                    productEntity.getTwoStarRatingCount() +
                    productEntity.getThreeStarRatingCount() +
                    productEntity.getFourStarRatingCount() +
                    productEntity.getFiveStarRatingCount();

            productEntity.setRatingCount(ratingCount);

            productEntity.setRatingValue(0.0);

            double ratingValue = (productEntity.getOneStarRatingCount()) +
                    (2 * productEntity.getTwoStarRatingCount()) +
                    (3 * productEntity.getThreeStarRatingCount()) +
                    (4 * productEntity.getFourStarRatingCount()) +
                    (5 * productEntity.getFiveStarRatingCount());

            if (ratingCount != 0 || ratingValue != 0) {
                productEntity.setRatingValue(ratingValue / ratingCount);
            }

            return productEntity;
        }
        return null;
    }

}
