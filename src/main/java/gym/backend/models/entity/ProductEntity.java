package gym.backend.models.entity;

import gym.backend.models.entity.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "products")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity extends BaseEntity {

    @Column
    private String sku;

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

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<TasteEntity> taste;

    @Column
    private String weightKg;

    @Column
    private Double regularPrice;

    @Column
    private Double discountedPrice;

    @Column
    private Boolean isAvailable;

    @Column
    private Double enemyPrice;

    @Column
    private Double ratingValue;

    @Column
    private Integer ratingCount;

    @Column
    private Integer oneStarRatingCount;

    @Column
    private Integer twoStarRatingCount;

    @Column
    private Integer threeStarRatingCount;

    @Column
    private Integer fourStarRatingCount;

    @Column
    private Integer fiveStarRatingCount;
}
