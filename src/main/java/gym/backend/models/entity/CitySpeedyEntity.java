package gym.backend.models.entity;

import gym.backend.models.entity.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "cities")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CitySpeedyEntity extends BaseEntity {

    @Column(name = "speedy_id")
    private Long speedyId;

    @Column(name = "site_name")
    private String cityName;

    @Column(name = "post_code")
    private String postCode;

    @OneToMany(fetch = FetchType.EAGER)
    private List<AddressSpeedyEntity> addresses;

}
