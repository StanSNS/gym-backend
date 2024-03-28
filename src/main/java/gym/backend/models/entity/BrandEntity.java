package gym.backend.models.entity;


import gym.backend.models.entity.BaseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "brands")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BrandEntity extends BaseEntity {

    @Column
    private String brandID;

    @Column
    private String name;
}

