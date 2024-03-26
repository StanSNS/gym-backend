//package gym.backend.init;
//
//import com.google.gson.Gson;
//import gym.backend.models.entity.BrandEntity;
//import gym.backend.models.entity.ProductEntity;
//import gym.backend.models.json.Brand.BrandJSON;
//import gym.backend.models.json.Product.ProductJSON;
//import gym.backend.models.json.Product.ProductsJSON;
//import gym.backend.repository.ProductEntityRepository;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Map;
//
//@Component
//@RequiredArgsConstructor
//public class ProductInit {
//
//    @Value("${sila.bg}")
//    private String SILA_BG_API_TOKEN;
//
//    private final ProductEntityRepository productEntityRepository;
//    private final Gson gson;
//
//    @PostConstruct
//    public void validateProductsByModelId(){
//        String brandURL = ("https://distro.silabg.com/api/v1/product?api_token=" + SILA_BG_API_TOKEN);
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//
//        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
//
//        ResponseEntity<String> responseEntity = restTemplate.exchange(brandURL, HttpMethod.GET, requestEntity, String.class);
//
//        if (responseEntity.getStatusCode().toString().startsWith("200")) {
//            ProductsJSON productsJSON = gson.fromJson(responseEntity.getBody(), ProductsJSON.class);
//
//            for (ProductJSON singleData : productsJSON.getData()) {
//                if(productEntityRepository.existsByModelId(singleData.getModel_id())){
//                    ProductEntity productEntity = productEntityRepository.findProductEntityByModelId(singleData.getModel_id());
//
//
//                }else if (!productEntityRepository.existsByModelId(singleData.getModel_id())){
//
//                }
//            }
//
//            System.out.println();
//        }
//
//
//    }
//
//}
