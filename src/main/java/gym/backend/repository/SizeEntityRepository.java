package gym.backend.repository;

import gym.backend.models.entity.BaseEntity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeEntityRepository extends JpaRepository<SizeEntity,Long> {

    SizeEntity getSizeEntitiesById(Long id);

    boolean existsBySizeId(String id);
}
