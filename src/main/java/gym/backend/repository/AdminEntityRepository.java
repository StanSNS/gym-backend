package gym.backend.repository;

import gym.backend.models.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminEntityRepository extends JpaRepository<AdminEntity, Long> {
    Optional<AdminEntity> findFirstByOrderByIdAsc();

    Optional<AdminEntity> findByUsername(String username);
}
