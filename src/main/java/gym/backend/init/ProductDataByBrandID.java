//package gym.backend.init;
//
//import com.google.gson.Gson;
//import gym.backend.models.entity.BrandEntity;
//import gym.backend.models.entity.ProductEntity;
//import gym.backend.models.entity.SizeEntity;
//import gym.backend.models.entity.TasteEntity;
//import gym.backend.models.json.ProductData.ProductJSONFromBrand;
//import gym.backend.models.json.ProductData.ProductsJSONFromBrand;
//import gym.backend.models.json.Size.SizeJSON;
//import gym.backend.models.json.Size.SizeJSONData;
//import gym.backend.models.json.Size.SizeJSONList;
//import gym.backend.models.json.Taste.TasteJSON;
//import gym.backend.models.json.Taste.TasteJSONData;
//import gym.backend.models.json.Taste.TasteJSONList;
//import gym.backend.repository.BrandEntityRepository;
//import gym.backend.repository.ProductEntityRepository;
//import gym.backend.repository.SizeEntityRepository;
//import gym.backend.repository.TasteEntityRepository;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//@RequiredArgsConstructor
//public class ProductDataByBrandID {
//
//
//
//    private final BrandEntityRepository brandEntityRepository;
//    private final Gson gson;
//    private final ModelMapper modelMapper;
//    private final TasteEntityRepository tasteEntityRepository;
//    private final SizeEntityRepository sizeEntityRepository;
//    private final ProductEntityRepository productEntityRepository;
//
//    public void saveProductDataByBrandID() {
//        if (tasteEntityRepository.count() == 0 && sizeEntityRepository.count() == 0) {
//            System.out.println("Start filling tha DB with Sizes and Tastes data... (This may take a few minutes.)");
//            for (int i = 0; i < 3; i++) {
//                for (BrandEntity brandEntity : brandEntityRepository.findAll()) {
//                    if (!brandEntity.getBrandID().equals("169")) {
//                        initTestesAndSizesByBrandID(brandEntity.getBrandID());
//                    }
//                }
//            }
//
//            System.out.println("Total Tastes saved in the DB: " + tasteEntityRepository.count());
//            System.out.println("Total Sizes saved in the DB: " + sizeEntityRepository.count());
//        } else {
//            System.out.println("Tastes and Sizes by brand already exist.");
//        }
//
//        if (productEntityRepository.count() == 0) {
//            System.out.println("Start filling the DB with Products data...");
//            for (BrandEntity brandEntity : brandEntityRepository.findAll()) {
//                if (!brandEntity.getBrandID().equals("169")) {
//                    initProductsByBrand(brandEntity.getBrandID());
//                }
//            }
//            System.out.println("Total products with details pushed: " + productEntityRepository.count());
//        } else {
//            System.out.println("Products by brand already exist.");
//        }
//    }
//
//    private void initProductsByBrand(String brandID) {
//        ResponseEntity<String> stringResponseEntity = sendRequest(brandID);
//        if (stringResponseEntity.getStatusCode().toString().startsWith("200")) {
//            ProductsJSONFromBrand productsJSONFromBrand = gson.fromJson(stringResponseEntity.getBody(), ProductsJSONFromBrand.class);
//
//            for (ProductJSONFromBrand singleProduct : productsJSONFromBrand.getData()) {
//                ProductEntity productEntity;
//
//                if (productEntityRepository.existsByModelId(singleProduct.getModel_id())) {
//                    productEntity = productEntityRepository.findProductEntityByModelId(singleProduct.getModel_id());
//                } else {
//                    productEntity = modelMapper.map(singleProduct, ProductEntity.class);
//                    productEntity.setModelId(singleProduct.getModel_id());
//                    productEntity.setBrandEntity(brandEntityRepository.findByName(singleProduct.getBrand()));
//                    productEntity.setWeightKg(singleProduct.getWeight_kg());
//                    productEntity.setSize(new HashSet<>());
//                    productEntity.setTaste(new HashSet<>());
//                }
//
//                productEntity.setSku(singleProduct.getId());
//                productEntity.setBarcode(singleProduct.getEan());
//
//                addUniqueTasteEntities(productEntity, singleProduct.getTaste());
//                addUniqueSizeEntities(productEntity, singleProduct.getSize());
//            }
//        }
//    }
//
//
//
//
//}
