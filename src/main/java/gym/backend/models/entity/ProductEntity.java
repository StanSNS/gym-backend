package gym.backend.models.entity;

import gym.backend.models.entity.BaseEntity.BaseEntity;
import gym.backend.models.entity.BaseEntity.SizeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "products")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity extends BaseEntity {

    @Column
    private String productId;

    @Column
    private String modelId;

    @Column
    private String name;

    @Column
    private String brand;

    @Column
    private String category;

    @Column
    private String ean;

    @Column
    private String image;

    @Column
    private String label;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private TasteEntity taste;

    @ManyToOne
    private SizeEntity size;

    @Column
    private String weightKg;

}
