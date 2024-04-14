package gym.backend.repository;

import gym.backend.models.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {

    boolean existsByRandomNumber(Long randomNumber);

}
