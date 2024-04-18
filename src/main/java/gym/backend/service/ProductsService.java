package gym.backend.service;

import com.google.gson.Gson;
import gym.backend.exception.ResourceNotFoundException;
import gym.backend.models.DTO.HomePageResponseDataDTO;
import gym.backend.models.DTO.SellableProductDTO;
import gym.backend.models.DTO.SingleProductDTO;
import gym.backend.models.DTO.SingleProductDataDTO;
import gym.backend.models.entity.ProductEntity;
import gym.backend.models.json.ProductRequest.ProductAvailability.ProductAvailabilityResponse;
import gym.backend.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RequiredArgsConstructor
@Service
public class ProductsService {

    @Value("${sila.bg}")
    private String SILA_BG_API_TOKEN;

    private final ProductEntityRepository productEntityRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public HomePageResponseDataDTO getFrontPageData() {
        HomePageResponseDataDTO homePageResponseDataDTO = new HomePageResponseDataDTO();

        for (ProductEntity productEntity : productEntityRepository.findAllSellableProducts()) {
            SellableProductDTO sellableProductDTO = modelMapper.map(productEntity, SellableProductDTO.class);

            double priceDiff = productEntity.getDiscountedPrice() * 1.3 - productEntity.getEnemyPrice();

            sellableProductDTO
                    .setReducedTotalAmountPercentage(priceDiff / productEntity.getEnemyPrice() * 100);

            homePageResponseDataDTO.getProducts().add(sellableProductDTO);

            String category = sellableProductDTO.getCategory();
            boolean categoryFound = false;
            for (Map<String, Integer> categoryMap : homePageResponseDataDTO.getCategories()) {
                if (categoryMap.containsKey(category)) {
                    int count = categoryMap.get(category);
                    categoryMap.put(category, count + 1);
                    categoryFound = true;
                    break;
                }
            }

            if (!categoryFound) {
                Map<String, Integer> categoryMap = new HashMap<>();
                categoryMap.put(category, 1);
                homePageResponseDataDTO.getCategories().add(categoryMap);
            }


            String brand = sellableProductDTO.getBrandEntity().getName();
            boolean brandFound = false;
            for (Map<String, Integer> brandMap : homePageResponseDataDTO.getBrands()) {
                if (brandMap.containsKey(brand)) {
                    int count = brandMap.get(brand);
                    brandMap.put(brand, count + 1);
                    brandFound = true;
                    break;
                }
            }

            if (!brandFound) {
                Map<String, Integer> brandMap = new HashMap<>();
                brandMap.put(brand, 1);
                homePageResponseDataDTO.getBrands().add(brandMap);
            }
        }
        return homePageResponseDataDTO;
    }

    public SingleProductDataDTO getSingleProduct(String sku, String modelId) {
        Optional<ProductEntity> productEntityBySkuAndModelId = productEntityRepository.findProductEntityBySkuAndModelId(sku, modelId);

        if (productEntityBySkuAndModelId.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        ProductEntity productEntity = productEntityBySkuAndModelId.get();
        SingleProductDataDTO singleProductDataDTO = modelMapper.map(productEntity, SingleProductDataDTO.class);
        singleProductDataDTO.setSingleProducts(new HashSet<>());

        for (ProductEntity entity : productEntityRepository.findAllSellableProductsByBrand(productEntity.getBrandEntity().getName())) {
            SingleProductDTO map = modelMapper.map(entity, SingleProductDTO.class);
            singleProductDataDTO.getSingleProducts().add(map);
        }

        return singleProductDataDTO;
    }

    public boolean checkIfProductIsAvailable(String brandId, String modelId, String tasteId) {
        String productsURL = "https://distro.silabg.com/api/v1/product?api_token=" + SILA_BG_API_TOKEN;
        String jsonData = "{\"brand_id\": \"" + brandId + "\", \"model_id\":\"" + modelId + "\",\"taste_id\":\"" + tasteId + "\"}";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonData, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(productsURL, HttpMethod.POST, requestEntity, String.class);

        ProductAvailabilityResponse productAvailabilityResponse = gson.fromJson(responseEntity.getBody(), ProductAvailabilityResponse.class);

        Integer productCount = productAvailabilityResponse.getCount();

        return switch (productCount) {
            case 0 -> false;
            case 1 -> productAvailabilityResponse.getData().get(0).getAvailable().equals("1");
            default -> false;
        };

    }

}
