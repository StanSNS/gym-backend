package gym.backend.init;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gym.backend.init.initService.RequestService;
import gym.backend.models.entity.BrandEntity;
import gym.backend.models.json.ProductData.ProductJSONFromBrand;
import gym.backend.models.json.ProductData.ProductsJSONFromBrand;
import gym.backend.repository.BrandEntityRepository;
import gym.backend.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDetailsDataInit {

    private final RequestService requestService;
    private final BrandEntityRepository brandEntityRepository;
    private final Gson gson;
    private final ProductEntityRepository productEntityRepository;

    public void detailsProductInit() {

        for (BrandEntity brandEntity : brandEntityRepository.findAll()) {
            ResponseEntity<String> responseEntity = requestService.getProductDataByBrandID(brandEntity.getBrandID());

            if (responseEntity.getStatusCode().toString().startsWith("200")) {
                JsonParser parser = new JsonParser();
                JsonObject responseObject = parser.parse(responseEntity.getBody()).getAsJsonObject();
                JsonElement dataElement = responseObject.get("data");

                if (!dataElement.isJsonPrimitive()) {
                    ProductsJSONFromBrand productsJSONFromBrand = gson.fromJson(responseEntity.getBody(), ProductsJSONFromBrand.class);

                    for (ProductJSONFromBrand singleProduct : productsJSONFromBrand.getData()) {
                        if (!productEntityRepository.existsByModelId(singleProduct.getModel_id())) {
                            System.out.println("That shit is missing... " + singleProduct.getModel_id());
                        }
                    }

                }

            }

        }

    }

}
