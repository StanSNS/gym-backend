package gym.backend.init.Products;

import com.google.gson.Gson;
import gym.backend.exception.InitDataException;
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

import java.util.ArrayList;

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
        ResponseEntity<String> responseEntity = requestService.getAllProductsData();
        if (responseEntity.getStatusCode().toString().startsWith("200")) {
            ProductsJSON productsJSON = gson.fromJson(responseEntity.getBody(), ProductsJSON.class);

            ArrayList<BrandEntity> brandEntityArrayList = new ArrayList<>();
            ArrayList<TasteEntity> tasteEntityArrayList = new ArrayList<>();

            if (brandEntityRepository.count() > 0) {
                brandEntityArrayList.addAll(brandEntityRepository.findAll());
            }

            if (tasteEntityRepository.count() > 0) {
                tasteEntityArrayList.addAll(tasteEntityRepository.findAll());
            }

            for (ProductJSON singleData : productsJSON.getData()) {
                if (!existsByBrandIDFromList(brandEntityArrayList, singleData.getBrand_id())) {
                    BrandEntity brandEntity = new BrandEntity();
                    brandEntity.setBrandID(singleData.getBrand_id());
                    brandEntity.setName(singleData.getBrand_name());
                    brandEntityArrayList.add(brandEntity);
                }

                if (singleData.getTaste_id() != null && singleData.getTaste_name() != null && !existsBySilaTasteIDFromList(tasteEntityArrayList, singleData.getTaste_id())) {
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
                    tasteEntityArrayList.add(tasteEntity);
                }
            }
            brandEntityRepository.saveAll(brandEntityArrayList);
            tasteEntityRepository.saveAll(tasteEntityArrayList);
        } else {
            throw new InitDataException("brand-taste-data-execute");
        }

    }

    private boolean existsByBrandIDFromList(ArrayList<BrandEntity> brandEntityArrayList, String brandID) {
        for (BrandEntity brandEntity : brandEntityArrayList) {
            if (brandEntity.getBrandID().equals(brandID)) {
                return true;
            }
        }
        return false;
    }

    private boolean existsBySilaTasteIDFromList(ArrayList<TasteEntity> tasteEntityArrayList, String tasteID) {
        for (TasteEntity tasteEntity : tasteEntityArrayList) {
            if (tasteEntity.getSilaTasteID().equals(tasteID)) {
                return true;
            }
        }
        return false;
    }

}
