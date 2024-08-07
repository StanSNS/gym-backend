package gym.backend.repository;

import gym.backend.models.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandEntityRepository extends JpaRepository<BrandEntity, Long> {
    BrandEntity findByName(String name);

    BrandEntity findByBrandID(String brandID);

    boolean existsByBrandID(String brandID);
}
