package gym.backend.repository;

import gym.backend.models.entity.OrderEntity;
import gym.backend.models.enums.OrderStatus;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {

    boolean existsByRandomNumber(Long randomNumber);

    OrderEntity findByRandomNumber(Long randomNumber);

    List<OrderEntity> findAllByEmail(String email);


}
