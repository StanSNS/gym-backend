package gym.backend.repository;

import gym.backend.models.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findProductEntityByModelId(String modelId);

    boolean existsByModelId(String modelId);

    boolean existsBySku(String skuNumber);

    List<ProductEntity> findAllByEnemyPriceNull();

    List<ProductEntity> findAllByBrandEntityName(String name);
}



