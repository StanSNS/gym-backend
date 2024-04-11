package gym.backend.repository;

import gym.backend.models.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductEntityRepository extends JpaRepository<OrderProductEntity, Long> {

}
