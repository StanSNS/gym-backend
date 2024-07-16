package gym.backend.models.entity;

import gym.backend.models.entity.BaseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "about_data")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AboutDataEntity extends BaseEntity {

    @Column
    private Double savedMoney;

    @Column
    private Integer soldProducts;

    @Column
    private Integer satisfiedClients;

    @Column
    private Integer deliveredProducts;
}
