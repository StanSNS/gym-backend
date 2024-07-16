package gym.backend.repository;

import gym.backend.models.entity.AboutDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AboutDataEntityRepository extends JpaRepository<AboutDataEntity, Long> {

    Optional<AboutDataEntity> findFirstByOrderByIdAsc();
}
