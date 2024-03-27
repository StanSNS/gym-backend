package gym.backend.repository;

import gym.backend.models.entity.SizeEntity;
import gym.backend.models.entity.TasteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SizeEntityRepository extends JpaRepository<SizeEntity, Long> {

    boolean existsBySilaSizeID(String id);

    SizeEntity findBySilaSizeID(String silaSizeID);

    Optional<SizeEntity> findSizeEntityBySilaSizeID(String sizeID);

}
