package gym.backend.init.Products;

import com.google.gson.Gson;
import gym.backend.init.initService.RequestService;
import gym.backend.models.entity.ProductEntity;
import gym.backend.models.json.ProductRequest.Product.ProductJSON;
import gym.backend.models.json.ProductRequest.Product.ProductsJSON;
import gym.backend.repository.BrandEntityRepository;
import gym.backend.repository.ProductEntityRepository;
import gym.backend.repository.TasteEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@RequiredArgsConstructor
public class ProductDataInit {

    private final RequestService requestService;
    private final Gson gson;
    private final BrandEntityRepository brandEntityRepository;
    private final TasteEntityRepository tasteEntityRepository;
    private final ProductEntityRepository productEntityRepository;

    public void startInit() {
        ResponseEntity<String> responseEntity = requestService.getAllProductsData();

        if (responseEntity.getStatusCode().toString().startsWith("200")) {

            ProductsJSON productsJSON = gson.fromJson(responseEntity.getBody(), ProductsJSON.class);

            for (ProductJSON singleProduct : productsJSON.getData()) {
                ProductEntity productEntity = new ProductEntity();

                if (productEntityRepository.existsByModelId(singleProduct.getModel_id())) {
                    productEntity = productEntityRepository.findProductEntityByModelId(singleProduct.getModel_id());

                    if (singleProduct.getTaste_id() != null) {
                        productEntity.getTaste().add(tasteEntityRepository.findTasteEntityBySilaTasteID(singleProduct.getTaste_id()).get());
                    }

                } else {
                    productEntity.setModelId(singleProduct.getModel_id());
                    productEntity.setName(singleProduct.getProduct_name());
                    productEntity.setBrandEntity(brandEntityRepository.findByBrandID(singleProduct.getBrand_id()));
                    productEntity.setRegularPrice((Double.parseDouble(singleProduct.getRegular_price())));
                    productEntity.setIsAvailable(singleProduct.getAvailable().equals("1"));
                    productEntity.setTaste(new HashSet<>());
                }

                productEntity.setRatingCount(0);
                productEntity.setRatingValue(0.0);

                productEntityRepository.save(productEntity);
            }
        }

    }
}
