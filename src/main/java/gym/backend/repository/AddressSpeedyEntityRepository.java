package gym.backend.repository;

import gym.backend.models.entity.AddressSpeedyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressSpeedyEntityRepository extends JpaRepository<AddressSpeedyEntity, Long> {
}
