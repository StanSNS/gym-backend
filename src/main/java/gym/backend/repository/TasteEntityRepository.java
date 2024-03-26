package gym.backend.repository;

import gym.backend.models.entity.TasteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasteEntityRepository extends JpaRepository<TasteEntity, Long> {

    TasteEntity getTasteEntitiesById(Long id);

    boolean existsByTasteId(String id);

}
