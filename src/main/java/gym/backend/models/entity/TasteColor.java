package gym.backend.models.entity;

import gym.backend.models.entity.BaseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "taste_color")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TasteColor extends BaseEntity {
    @Column
    private String name;

    @Column
    private String color;
}
