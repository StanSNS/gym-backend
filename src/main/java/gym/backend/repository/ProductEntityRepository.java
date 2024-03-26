package gym.backend.repository;

import gym.backend.models.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findProductEntityByModelId(String modelId);
    boolean existsByModelId(String modelId);
}



