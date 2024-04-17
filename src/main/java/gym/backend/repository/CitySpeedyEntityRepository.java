package gym.backend.repository;

import gym.backend.models.entity.CitySpeedyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitySpeedyEntityRepository extends JpaRepository<CitySpeedyEntity, Long> {

    Optional<CitySpeedyEntity> findByCityName(String cityName);

}
