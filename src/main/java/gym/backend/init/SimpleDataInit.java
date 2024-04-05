package gym.backend.init;

import com.google.gson.Gson;
import gym.backend.init.initService.RequestService;
import gym.backend.models.entity.BrandEntity;
import gym.backend.models.entity.SizeEntity;
import gym.backend.models.entity.TasteColor;
import gym.backend.models.entity.TasteEntity;
import gym.backend.models.json.Product.ProductJSON;
import gym.backend.models.json.Product.ProductsJSON;
import gym.backend.repository.BrandEntityRepository;
import gym.backend.repository.SizeEntityRepository;
import gym.backend.repository.TasteColorEntityRepository;
import gym.backend.repository.TasteEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleDataInit {

    private final BrandEntityRepository brandEntityRepository;
    private final TasteEntityRepository tasteEntityRepository;
    private final SizeEntityRepository sizeEntityRepository;
    private final TasteColorEntityRepository tasteColorEntityRepository;
    private final RequestService requestService;
    private final Gson gson;

    public void startInit() {
        ResponseEntity<String> responseEntity = requestService.getAllProductsData();
        if (responseEntity.getStatusCode().toString().startsWith("200")) {
            ProductsJSON productsJSON = gson.fromJson(responseEntity.getBody(), ProductsJSON.class);

            if (brandEntityRepository.count() == 0 && tasteEntityRepository.count() == 0 && sizeEntityRepository.count() == 0) {
                System.out.println("Start filling the DB with Tastes, Sizes and Brands...");
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
                        tasteEntity.setName(singleData.getTaste_name());
                        tasteEntity.setSilaTasteID(singleData.getTaste_id());

                        for (String singleTaste : tasteEntity.getName().split(" ")) {
                            TasteColor tasteColor = tasteColorEntityRepository.findByNameIgnoreCase(singleTaste);
                            if(tasteColor != null){
                                tasteEntity.setColors(tasteEntity.getColors() + tasteColor.getColor() + ", ");
                            }
                        }
                        tasteEntityRepository.save(tasteEntity);
                    }

                    if (!sizeEntityRepository.existsBySilaSizeID(singleData.getSize_id()) && singleData.getSize_id() != null && singleData.getSize_name() != null) {
                        SizeEntity sizeEntity = new SizeEntity();
                        sizeEntity.setSilaSizeID(singleData.getSize_id());
                        sizeEntity.setName(singleData.getSize_name());
                        sizeEntityRepository.save(sizeEntity);
                    }
                }
                System.out.println("Successfully added Brands, Tastes and Sizes.");
            }

        }

    }

}
