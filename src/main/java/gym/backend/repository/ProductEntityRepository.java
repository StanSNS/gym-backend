package gym.backend.repository;

import gym.backend.models.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findProductEntityByModelId(String modelId);

    boolean existsByModelId(String modelId);

    Optional<ProductEntity> findProductEntityBySku(String sku);

    List<ProductEntity> findProductEntitiesByDiscountedPriceNotNullAndIsAvailableTrue();

    Optional<ProductEntity> findProductEntityBySkuAndModelId(String sku, String modelId);

    @Query(value = """
            SELECT *
            FROM products
            WHERE discounted_price IS NOT NULL
              AND discounted_price != 0
              AND enemy_price IS NOT NULL
              AND model_id != ''
              AND model_id is not null
              AND is_available = TRUE
              AND image IS NOT NULL
              AND image != ''
              AND category IS NOT NULL
              AND category != ''
              AND weight_kg IS NOT NULL
              AND weight_kg != ''
              AND products.discounted_price * 1.3 < enemy_price
              AND products.discounted_price * 1.3 < products.regular_price
            ORDER BY (products.discounted_price * 1.3 - products.enemy_price)""", nativeQuery = true)
    List<ProductEntity> findAllSellableProducts();
}
