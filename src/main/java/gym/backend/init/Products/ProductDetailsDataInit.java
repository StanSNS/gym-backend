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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import static gym.backend.utils.TimeUtils.convertMsToTime;

@Component
@RequiredArgsConstructor
public class ProductDetailsDataInit {

    private final RequestService requestService;
    private final BrandEntityRepository brandEntityRepository;
    private final Gson gson;
    private final ProductEntityRepository productEntityRepository;
    private final ModelMapper modelMapper;
    private final TasteEntityRepository tasteEntityRepository;

    @CacheEvict(value = "allSellableProducts", allEntries = true)
    public void startInit() {
        long startTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("START -> product-data-details-execute...");
        for (BrandEntity brandEntity : brandEntityRepository.findAll()) {
            ResponseEntity<String> responseEntity = requestService.getProductDataByBrandID(brandEntity.getBrandID());

            if (responseEntity.getStatusCode().toString().startsWith("200")) {
                JsonParser parser = new JsonParser();
                JsonObject responseObject = parser.parse(responseEntity.getBody()).getAsJsonObject();
                JsonElement dataElement = responseObject.get("data");

                if (!dataElement.isJsonPrimitive()) {
                    ProductsJSONFromBrand productsJSONFromBrand = gson.fromJson(responseEntity.getBody(), ProductsJSONFromBrand.class);

                    ArrayList<ProductEntity> productEntityArrayList = new ArrayList<>();

                    for (ProductJSONFromBrand singleProduct : productsJSONFromBrand.getData()) {
                        ProductEntity productEntity = productEntityRepository.findProductEntityByModelId(singleProduct.getModel_id());

                        if (productEntity == null) {
                            productEntity = modelMapper.map(singleProduct, ProductEntity.class);
                            productEntity.setSku(singleProduct.getId());
                            productEntity.setModelId(singleProduct.getModel_id());
                            productEntity.setBrandEntity(brandEntityRepository.findByName(singleProduct.getBrand()));
                            productEntity.setTaste(new HashSet<>());
                            productEntity.setWeightKg(singleProduct.getWeight_kg());

                            addTastesInProductEntity(singleProduct, productEntity);
                        } else {
                            productEntity.setSku(singleProduct.getId());
                            productEntity.setCategory(singleProduct.getCategory());
                            productEntity.setImage(singleProduct.getImage());
                            productEntity.setLabel(singleProduct.getLabel());
                            productEntity.setDescription(singleProduct.getDescription());
                            productEntity.setWeightKg(singleProduct.getWeight_kg());

                            addTastesInProductEntity(singleProduct, productEntity);
                        }
                        productEntityArrayList.add(productEntity);
                    }

                    productEntityRepository.saveAll(productEntityArrayList);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("END   -> product-data-details-execute... " + convertMsToTime(executionTime));
    }

    private void addTastesInProductEntity(ProductJSONFromBrand singleProduct, ProductEntity productEntity) {
        if (!singleProduct.getTaste().isEmpty()) {
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
