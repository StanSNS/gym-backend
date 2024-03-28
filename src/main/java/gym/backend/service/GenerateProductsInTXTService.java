package gym.backend.service;

import gym.backend.models.entity.ProductEntity;
import gym.backend.models.entity.SizeEntity;
import gym.backend.models.entity.TasteEntity;
import gym.backend.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenerateProductsInTXTService {

    private final ProductEntityRepository productEntityRepository;

    private final String TITLE_PRODUCT_TEMPLATE = "[№%s] %s %s %s %.2fлв <br>";
    private final String TASTE_PRODUCT_TEMPLATE = "- %s <br>";
    private final String SIZE_PRODUCT_TEMPLATE = "- %s <br>";
    private final String CATEGORY_PRODUCT_TEMPLATE = "(%s) <br> <br>";

    public StringBuilder generateProductsAsString() {
        StringBuilder sb = new StringBuilder();

        for (ProductEntity productEntity : productEntityRepository.findAllSellableProducts()) {
            sb.append(String.format(TITLE_PRODUCT_TEMPLATE,
                    productEntity.getSku(),
                    productEntity.getBrandEntity().getName(),
                    productEntity.getName(),
                    (Double.parseDouble(productEntity.getWeightKg()) != 0.0) ? productEntity.getWeightKg() + "kg = " : " = ",
                    Math.ceil(productEntity.getDiscountedPrice() * 1.5)));

            for (TasteEntity tasteEntity : productEntity.getTaste()) {
                sb.append(String.format(TASTE_PRODUCT_TEMPLATE, tasteEntity.getName()));
            }

            if (productEntity.getSize().size() > 0) {

                sb.append(String.format(SIZE_PRODUCT_TEMPLATE, productEntity
                        .getSize()
                        .stream()
                        .map(SizeEntity::getName)
                        .collect(Collectors.joining(", "))));
            }

            sb.append(String.format(CATEGORY_PRODUCT_TEMPLATE, productEntity.getCategory()));
        }
        return sb;
    }

}
