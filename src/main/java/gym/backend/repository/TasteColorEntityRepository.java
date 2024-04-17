package gym.backend.repository;

import gym.backend.models.entity.TasteColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasteColorEntityRepository extends JpaRepository<TasteColor, Long> {

    TasteColor findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);
}
