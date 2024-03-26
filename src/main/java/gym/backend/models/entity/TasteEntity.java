package gym.backend.models.entity;

import gym.backend.models.entity.BaseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tastes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TasteEntity extends BaseEntity {
    private String tasteId;
    private String name;
    private String ean;
}
