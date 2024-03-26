package gym.backend.init;

import com.google.gson.Gson;
import gym.backend.models.entity.BaseEntity.SizeEntity;
import gym.backend.models.entity.BrandEntity;
import gym.backend.models.entity.ProductEntity;
import gym.backend.models.entity.TasteEntity;
import gym.backend.models.json.Product.ProductJSON;
import gym.backend.models.json.Product.ProductsJSON;
import gym.backend.models.json.Product.SizeJSON;
import gym.backend.models.json.Product.TasteJSON;
import gym.backend.repository.BrandEntityRepository;
import gym.backend.repository.ProductEntityRepository;
import gym.backend.repository.SizeEntityRepository;
import gym.backend.repository.TasteEntityRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProductAndTasteAndSizeInit {

    @Value("${sila.bg}")
    private String SILA_BG_API_TOKEN;

    private final BrandEntityRepository brandEntityRepository;
    private final ProductEntityRepository productEntityRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final TasteEntityRepository tasteEntityRepository;
    private final SizeEntityRepository sizeEntityRepository;


    @PostConstruct
    public void productInit() {
        if (productEntityRepository.count() > 0) {
            System.out.println("Products are saved");
            return;
        }

        for (BrandEntity brandEntity : brandEntityRepository.findAll()) {
            if (!brandEntity.getBrandID().equals("169")) {
                initProductsByBrandId(brandEntity.getBrandID());
            }
        }
    }

    private void initProductsByBrandId(String brandId) {
        String productsURL = "https://distro.silabg.com/api/v1/brandfeed?api_token=" + SILA_BG_API_TOKEN;
        String jsonData = "{\"brand_id\": \"" + brandId + "\"}";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonData, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(productsURL, HttpMethod.POST, requestEntity, String.class);

        ProductsJSON productsJSON = gson.fromJson(responseEntity.getBody(), ProductsJSON.class);

        for (ProductJSON singleProduct : productsJSON.getData()) {
            ProductEntity productEntity = modelMapper.map(singleProduct, ProductEntity.class);
            productEntity.setModelId(singleProduct.getModel_id());
            productEntity.setWeightKg(singleProduct.getWeight_kg());
            productEntity.setProductId(singleProduct.getId());
            productEntity.setId(0L);

            for (TasteJSON tasteJSON : singleProduct.getTaste()) {
                TasteEntity tasteEntity = modelMapper.map(tasteJSON, TasteEntity.class);
                tasteEntity.setId(0L);

                if (!tasteEntityRepository.existsByTasteId(tasteJSON.getId())) {
                    Long savedTasteID = tasteEntityRepository.save(tasteEntity).getId();
                    productEntity.setTaste(tasteEntityRepository.getTasteEntitiesById(savedTasteID));
                }
            }

            for (SizeJSON sizeJSON : singleProduct.getSize()) {
                SizeEntity sizeEntity = modelMapper.map(sizeJSON, SizeEntity.class);
                sizeEntity.setId(0L);

                if (!sizeEntityRepository.existsBySizeId(sizeJSON.getId())) {
                    Long savedSizeID = sizeEntityRepository.save(sizeEntity).getId();
                    productEntity.setSize(sizeEntityRepository.getSizeEntitiesById(savedSizeID));
                }
            }
            productEntityRepository.save(productEntity);
        }
    }


}
