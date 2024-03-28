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
            "join products_taste pt on products.id = pt.product_entity_id\n" +
            "WHERE discounted_price IS NOT NULL\n" +
            "  and discounted_price != 0\n" +
            "  AND enemy_price IS NOT NULL\n" +
            "  AND is_available = true\n" +
            "  AND products.discounted_price * 1.5 < enemy_price", nativeQuery = true)
    List<ProductEntity> findAllSellableProducts();
}
