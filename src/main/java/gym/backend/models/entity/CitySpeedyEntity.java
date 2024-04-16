package gym.backend.models.entity;

import gym.backend.models.entity.BaseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cities_speedy")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CitySpeedyEntity extends BaseEntity {

    @Column(name = "speedy_id")
    private Long speedyId;

    @Column(name = "site_name_bg")
    private String siteNameBg;

    @Column(name = "site_name_en")
    private String siteNameEn;

    @Column(name = "site_type_bg")
    private String siteTypeBg;

    @Column(name = "site_type_en")
    private String siteTypeEn;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "address_bg")
    private String addressBG;

    @Column(name = "address_en")
    private String addressEN;
}
