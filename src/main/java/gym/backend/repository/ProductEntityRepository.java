package gym.backend.repository;

import gym.backend.models.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findProductEntityByModelId(String modelId);

    boolean existsByModelId(String modelId);

    Optional<ProductEntity> findProductEntityBySku(String sku);

    List<ProductEntity> findProductEntitiesByDiscountedPriceNotNullAndIsAvailableTrue();


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
              AND products.discounted_price * 1.4 < enemy_price
              AND products.discounted_price * 1.4 < products.regular_price
            ORDER BY (products.discounted_price * 1.4 - products.enemy_price)""", nativeQuery = true)
    List<ProductEntity> findAllSellableProducts();

    @Query(value = """
        SELECT p.*
        FROM products p
        JOIN brands b ON b.id = p.brand_entity_id
        WHERE b.name = :brandName
          AND p.discounted_price IS NOT NULL
          AND p.discounted_price != 0
          AND p.enemy_price IS NOT NULL
          AND p.model_id != ''
          AND p.model_id IS NOT NULL
          AND p.is_available = TRUE
          AND p.image IS NOT NULL
          AND p.image != ''
          AND p.category IS NOT NULL
          AND p.category != ''
          AND p.weight_kg IS NOT NULL
          AND p.weight_kg != ''
          AND p.discounted_price * 1.4 < p.enemy_price
          AND p.discounted_price * 1.4 < p.regular_price
        ORDER BY (p.discounted_price * 1.4 - p.enemy_price)
        LIMIT 10""", nativeQuery = true)
    List<ProductEntity> findAllSellableProductsByBrand(@Param("brandName") String brandName);



}
