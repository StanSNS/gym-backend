package gym.backend.init.Products;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gym.backend.init.initService.RequestService;
import gym.backend.models.entity.BrandEntity;
import gym.backend.models.entity.ProductEntity;
import gym.backend.models.entity.TasteEntity;
import gym.backend.models.json.ProductRequest.ProductData.ProductJSONFromBrand;
import gym.backend.models.json.ProductRequest.ProductData.ProductsJSONFromBrand;
import gym.backend.models.json.ProductRequest.Taste.TasteJSON;
import gym.backend.repository.BrandEntityRepository;
import gym.backend.repository.ProductEntityRepository;
import gym.backend.repository.TasteEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductDetailsDataInit {

    private final RequestService requestService;
    private final BrandEntityRepository brandEntityRepository;
    private final Gson gson;
    private final ProductEntityRepository productEntityRepository;
    private final ModelMapper modelMapper;
    private final TasteEntityRepository tasteEntityRepository;

    public void startInit() {
        for (BrandEntity brandEntity : brandEntityRepository.findAll()) {
            ResponseEntity<String> responseEntity = requestService.getProductDataByBrandID(brandEntity.getBrandID());

            if (responseEntity.getStatusCode().toString().startsWith("200")) {
                JsonParser parser = new JsonParser();
                JsonObject responseObject = parser.parse(responseEntity.getBody()).getAsJsonObject();
                JsonElement dataElement = responseObject.get("data");

                if (!dataElement.isJsonPrimitive()) {
                    ProductsJSONFromBrand productsJSONFromBrand = gson.fromJson(responseEntity.getBody(), ProductsJSONFromBrand.class);
                    ProductEntity productEntity = new ProductEntity();

                    for (ProductJSONFromBrand singleProduct : productsJSONFromBrand.getData()) {
                        if (!productEntityRepository.existsByModelId(singleProduct.getModel_id())) {
                            productEntity = modelMapper.map(singleProduct, ProductEntity.class);
                            productEntity.setSku(singleProduct.getId());
                            productEntity.setModelId(singleProduct.getModel_id());
                            productEntity.setBrandEntity(brandEntityRepository.findByName(singleProduct.getBrand()));
                            productEntity.setTaste(new HashSet<>());
                            productEntity.setWeightKg(singleProduct.getWeight_kg());

                            addTastesInProductEntity(singleProduct, productEntity);
                        } else {
                            productEntity = productEntityRepository.findProductEntityByModelId(singleProduct.getModel_id());
                            productEntity.setSku(singleProduct.getId());
                            productEntity.setCategory(singleProduct.getCategory());
                            productEntity.setImage(singleProduct.getImage());
                            productEntity.setLabel(singleProduct.getLabel());
                            productEntity.setDescription(singleProduct.getDescription());
                            productEntity.setWeightKg(singleProduct.getWeight_kg());

                            addTastesInProductEntity(singleProduct, productEntity);
                        }
                        productEntityRepository.save(productEntity);
                    }
                }
            }
        }
    }

    private void addTastesInProductEntity(ProductJSONFromBrand singleProduct, ProductEntity productEntity) {
        if (singleProduct.getTaste().size() > 0) {
            for (TasteJSON tasteJSON : singleProduct.getTaste()) {
                Optional<TasteEntity> tasteEntityBySilaTasteID = tasteEntityRepository.findTasteEntityBySilaTasteID(tasteJSON.getId());
                if (tasteEntityBySilaTasteID.isPresent()) {
                    productEntity.getTaste().add(tasteEntityBySilaTasteID.get());
                } else {
                    TasteEntity tasteEntity = new TasteEntity();
                    tasteEntity.setSilaTasteID(tasteJSON.getId());
                    tasteEntity.setName(tasteJSON.getName());
                    tasteEntityRepository.save(tasteEntity);
                    productEntity.getTaste().add(tasteEntity);
                }
            }
        }
    }

}
