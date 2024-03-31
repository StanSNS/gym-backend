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

    Optional<ProductEntity> findProductEntityBySkuAndBarcodeNull(String sku);

    Optional<ProductEntity> findProductEntityBySku(String sku);

    List<ProductEntity> findProductEntitiesByDiscountedPriceNotNullAndIsAvailableTrue();

    @Query(value = "SELECT *\n" +
            "FROM products\n" +
            "WHERE discounted_price IS NOT NULL\n" +
            "  AND discounted_price != 0\n" +
            "  AND enemy_price IS NOT NULL\n" +
            "  AND is_available = TRUE\n" +
            "  AND image IS NOT NULL\n" +
            "  AND image != ''\n" +
            "  AND category IS NOT NULL\n" +
            "  AND category != ''\n" +
            "  AND weight_kg != ''\n" +
            "  AND weight_kg is not null\n" +
            "  AND products.discounted_price * 1.4 < enemy_price\n" +
            "ORDER BY (products.discounted_price * 1.4 - products.enemy_price) ASC", nativeQuery = true)
    List<ProductEntity> findAllSellableProducts();
}
