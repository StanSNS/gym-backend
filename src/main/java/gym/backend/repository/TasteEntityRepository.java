package gym.backend.repository;

import gym.backend.models.entity.TasteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TasteEntityRepository extends JpaRepository<TasteEntity, Long> {

    boolean existsBySilaTasteID(String silaTasteID);
    Optional<TasteEntity> findTasteEntityBySilaTasteID(String tasteID);
}
