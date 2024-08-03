package gym.backend.init.Products;

import com.google.gson.Gson;
import gym.backend.exception.InitDataException;
import gym.backend.exception.ResourceNotFoundException;
import gym.backend.init.initService.RequestService;
import gym.backend.models.entity.ProductEntity;
import gym.backend.models.entity.TasteEntity;
import gym.backend.models.json.ProductRequest.Product.ProductJSON;
import gym.backend.models.json.ProductRequest.Product.ProductsJSON;
import gym.backend.repository.BrandEntityRepository;
import gym.backend.repository.ProductEntityRepository;
import gym.backend.repository.TasteEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductDataInit {

    private final RequestService requestService;
    private final Gson gson;
    private final BrandEntityRepository brandEntityRepository;
    private final TasteEntityRepository tasteEntityRepository;
    private final ProductEntityRepository productEntityRepository;

    @CacheEvict(value = "allSellableProducts", allEntries = true)
    public void startInit() {
        ResponseEntity<String> responseEntity = requestService.getAllProductsData();

        if (responseEntity.getStatusCode().toString().startsWith("200")) {
            ProductsJSON productsJSON = gson.fromJson(responseEntity.getBody(), ProductsJSON.class);

            ArrayList<ProductEntity> productEntityArrayList = new ArrayList<>();

            if (productEntityRepository.count() > 0) {
                productEntityArrayList.addAll(productEntityRepository.findAll());
            }

            for (ProductJSON singleProduct : productsJSON.getData()) {
                ProductEntity productEntity = findProductByModelIDFromList(productEntityArrayList, singleProduct.getModel_id());

                if (productEntity != null) {
                    if (singleProduct.getTaste_id() != null) {
                        Optional<TasteEntity> tasteEntityBySilaTasteID = tasteEntityRepository.findTasteEntityBySilaTasteID(singleProduct.getTaste_id());
                        if (tasteEntityBySilaTasteID.isEmpty()) {
                            throw new ResourceNotFoundException();
                        }
                        productEntity.getTaste().add(tasteEntityBySilaTasteID.get());
                    }

                } else {
                    productEntity = new ProductEntity();
                    productEntity.setModelId(singleProduct.getModel_id());
                    productEntity.setName(singleProduct.getProduct_name());
                    productEntity.setBrandEntity(brandEntityRepository.findByBrandID(singleProduct.getBrand_id()));
                    productEntity.setRegularPrice((Double.parseDouble(singleProduct.getRegular_price())));
                    productEntity.setIsAvailable(singleProduct.getAvailable().equals("1"));
                    productEntity.setTaste(new HashSet<>());
                }

                productEntity.setRatingCount(0);
                productEntity.setRatingValue(0.0);

                productEntityArrayList.add(productEntity);
            }

            productEntityRepository.saveAll(productEntityArrayList);
        } else {
            throw new InitDataException("product-data-execute");
        }

    }

    public static ProductEntity findProductByModelIDFromList(ArrayList<ProductEntity> productEntityArrayList, String modelId) {
        for (ProductEntity productEntity : productEntityArrayList) {
            if (productEntity.getModelId().equals(modelId)) {
                return productEntity;
            }
        }
        return null;
    }
}
