package gym.backend.repository;

import gym.backend.models.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findProductEntityByModelId(String modelId);

    boolean existsByModelId(String modelId);

    boolean existsBySku(String skuNumber);

    List<ProductEntity> findAllByEnemyPriceNull();

    List<ProductEntity> findAllByBrandEntityName(String name);

    boolean existsByBarcode(String barcode);

    Optional<ProductEntity> findProductEntityBySkuAndBarcodeNull(String sku);

    Optional<ProductEntity> findProductEntityBySku(String sku);


}



