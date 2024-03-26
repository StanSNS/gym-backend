package gym.backend.init;

import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductPriceInit {

    private final ProductEntityRepository productEntityRepository;

    @PostConstruct
    public void validateProductsByModelId(){

        ProductEntity productEntityByModelId = productEntityRepository.findProductEntityByModelId("8221");

        System.out.println();

    }

}
