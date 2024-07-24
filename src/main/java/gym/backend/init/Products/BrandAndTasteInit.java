package gym.backend.init.Products;

import com.google.gson.Gson;
import gym.backend.init.initService.RequestService;
import gym.backend.models.entity.BrandEntity;
import gym.backend.models.entity.TasteColor;
import gym.backend.models.entity.TasteEntity;
import gym.backend.models.json.ProductRequest.Product.ProductJSON;
import gym.backend.models.json.ProductRequest.Product.ProductsJSON;
import gym.backend.repository.BrandEntityRepository;
import gym.backend.repository.TasteColorEntityRepository;
import gym.backend.repository.TasteEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static gym.backend.utils.TimeUtils.convertMsToTime;

@Component
@RequiredArgsConstructor
public class BrandAndTasteInit {

    private final BrandEntityRepository brandEntityRepository;
    private final TasteEntityRepository tasteEntityRepository;
    private final TasteColorEntityRepository tasteColorEntityRepository;
    private final RequestService requestService;
    private final Gson gson;

    @CacheEvict(value = "allSellableProducts", allEntries = true)
    public void startInit() {
        long startTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("START -> brand-taste-data-execute...");
        ResponseEntity<String> responseEntity = requestService.getAllProductsData();
        if (responseEntity.getStatusCode().toString().startsWith("200")) {
            ProductsJSON productsJSON = gson.fromJson(responseEntity.getBody(), ProductsJSON.class);

            for (ProductJSON singleData : productsJSON.getData()) {
                if (!brandEntityRepository.existsByBrandID(singleData.getBrand_id())) {
                    BrandEntity brandEntity = new BrandEntity();
                    brandEntity.setBrandID(singleData.getBrand_id());
                    brandEntity.setName(singleData.getBrand_name());
                    brandEntityRepository.save(brandEntity);
                }

                if (!tasteEntityRepository.existsBySilaTasteID(singleData.getTaste_id()) && singleData.getTaste_id() != null && singleData.getTaste_name() != null) {
                    TasteEntity tasteEntity = new TasteEntity();
                    tasteEntity.setColors("");
                    tasteEntity.setColorNames("");
                    tasteEntity.setName(singleData.getTaste_name());
                    tasteEntity.setSilaTasteID(singleData.getTaste_id());

                    for (String singleTaste : tasteEntity.getName().split(" ")) {
                        TasteColor tasteColor = tasteColorEntityRepository.findByNameIgnoreCase(singleTaste);
                        if (tasteColor != null) {
                            tasteEntity.setColors(tasteEntity.getColors() + tasteColor.getColor() + ", ");
                            tasteEntity.setColorNames(tasteEntity.getColorNames() + tasteColor.getName() + ", ");
                        }
                    }
                    tasteEntityRepository.save(tasteEntity);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("END   -> brand-taste-data-execute... " + convertMsToTime(executionTime));
    }

}
