package gym.backend.service;

import gym.backend.models.DTO.HomePageResponseDataDTO;
import gym.backend.models.DTO.SellableProductDTO;
import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@RequiredArgsConstructor
@Service
public class ProductsService {

    private final ProductEntityRepository productEntityRepository;
    private final ModelMapper modelMapper;

    public HomePageResponseDataDTO getFrontPageData() {
        HomePageResponseDataDTO homePageResponseDataDTO = new HomePageResponseDataDTO();

        for (ProductEntity productEntity : productEntityRepository.findAllSellableProducts()) {
            SellableProductDTO sellableProductDTO = modelMapper.map(productEntity, SellableProductDTO.class);
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
                Map<String, Integer> categoryMap = new TreeMap<>();
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
                Map<String, Integer> brandMap = new TreeMap<>();
                brandMap.put(brand, 1);
                homePageResponseDataDTO.getBrands().add(brandMap);
            }
        }
        return homePageResponseDataDTO;
    }
}
