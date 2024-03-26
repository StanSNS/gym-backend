package gym.backend.models.entity;

import gym.backend.models.entity.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToOne
    private BrandEntity brandEntity;

    @Column
    private String category;

    @Column
    private String image;

    @Column
    private String label;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany
    private Set<TasteEntity> taste;

    @OneToMany
    private Set<SizeEntity> size;

    @Column
    private String weightKg;



}
