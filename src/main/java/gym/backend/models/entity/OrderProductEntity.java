package gym.backend.models.entity;

import gym.backend.models.entity.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "order_product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderProductEntity extends BaseEntity {

    @Column
    private Integer quantity;

    @Column
    private String modelId;

    @Column
    private String selectedTasteSilaId;
}
