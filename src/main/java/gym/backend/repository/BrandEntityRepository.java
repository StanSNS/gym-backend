package gym.backend.repository;

import gym.backend.models.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandEntityRepository extends JpaRepository<BrandEntity, Long> {

    BrandEntity findByName(String name);

}
