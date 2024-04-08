package gym.backend.service;

import gym.backend.exception.ResourceNotFoundException;
import gym.backend.models.DTO.HomePageResponseDataDTO;
import gym.backend.models.DTO.SellableProductDTO;
import gym.backend.models.DTO.SingleProduct;
import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductsService {

    private final ProductEntityRepository productEntityRepository;
    private final ModelMapper modelMapper;

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

    public SingleProduct getSingleProduct(String sku, String modelId) {
        Optional<ProductEntity> productEntityBySkuAndModelId = productEntityRepository.findProductEntityBySkuAndModelId(sku, modelId);

        if (productEntityBySkuAndModelId.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        ProductEntity productEntity = productEntityBySkuAndModelId.get();
        return modelMapper.map(productEntity, SingleProduct.class);
    }
}
