//package gym.backend.init;
//
//import com.google.gson.Gson;
//import gym.backend.models.entity.BrandEntity;
//import gym.backend.models.entity.ProductEntity;
//import gym.backend.models.entity.TasteEntity;
//import gym.backend.models.json.ProductData.ProductDataJSON;
//import gym.backend.models.json.ProductData.ProductsDataJSON;
//import gym.backend.models.json.Taste.TasteJSON;
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
//
//@Component
//@RequiredArgsConstructor
//public class BrandDataInit {
//
//    @Value("${sila.bg}")
//    private String SILA_BG_API_TOKEN;
//
//    private final BrandEntityRepository brandEntityRepository;
//    private final ProductEntityRepository productEntityRepository;
//    private final ModelMapper modelMapper;
//    private final Gson gson;
//    private final TasteEntityRepository tasteEntityRepository;
//    private final SizeEntityRepository sizeEntityRepository;
//
//
//    public void productInit() {
////        if (productEntityRepository.count() > 0) {
////            System.out.println("Products already exists.");
////            return;
////        }
//
////        if (brandEntityRepository.count() > 0) {
////            for (BrandEntity brandEntity : brandEntityRepository.findAll()) {
////                if (!brandEntity.getBrandID().equals("169")) {
////                    System.out.println("Adding data with id: " + brandEntity.getBrandID());
////                    initProductsByBrandId(brandEntity.getBrandID());
////                }
////            }
////        }
//        initProductsByBrandId("1");
//    }
//
//    private void initProductsByBrandId(String brandId) {
//        String productsURL = "https://distro.silabg.com/api/v1/brandfeed?api_token=" + SILA_BG_API_TOKEN;
//        String jsonData = "{\"brand_id\": \"" + brandId + "\"}";
//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//
//        HttpEntity<String> requestEntity = new HttpEntity<>(jsonData, headers);
//
//        ResponseEntity<String> responseEntity = restTemplate.exchange(productsURL, HttpMethod.POST, requestEntity, String.class);
//
//        ProductsDataJSON productsJSON = gson.fromJson(responseEntity.getBody(), ProductsDataJSON.class);
//
//        for (ProductDataJSON singleProduct : productsJSON.getData()) {
//            ProductEntity productEntity = modelMapper.map(singleProduct, ProductEntity.class);
//            productEntity.setModelId(singleProduct.getModel_id());
//            productEntity.setWeightKg(singleProduct.getWeight_kg());
//            productEntity.setProductId(singleProduct.getId());
//            productEntity.setId(0L);
//            productEntity.setTaste(new HashSet<>());
//
//            BrandEntity brandByName = brandEntityRepository.findByName(singleProduct.getBrand());
//            productEntity.setBrandEntity(brandByName);
//
//            for (TasteJSON tasteJSON : singleProduct.getTaste()) {
//                TasteEntity tasteEntity = modelMapper.map(tasteJSON, TasteEntity.class);
//
//                if (!tasteEntityRepository.existsById(tasteEntity.getId())) {
//                    tasteEntityRepository.save(tasteEntity);
//                }
//
//                productEntity.getTaste().add(tasteEntity);
//
//
//
//            }
//
//
//            System.out.println();
////            for (SizeJSON sizeJSON : singleProduct.getSize()) {
////                SizeEntity sizeEntity = modelMapper.map(sizeJSON, SizeEntity.class);
////                sizeEntity.setId(0L);
////
////
////            }
//            productEntityRepository.save(productEntity);
//        }
//    }
//
//
//}
