package gym.backend.models.entity;

import gym.backend.models.entity.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "orders")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity extends BaseEntity {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String country;

    @Column
    private String town;

    @Column
    private String address;

    @Column
    private String additionalAddress;

    @Column
    private String delivery;

    @Column
    private String courier;

    @Column
    private Double totalWeight;

    @Column
    private Double totalAmount;

    @ManyToMany
    private List<OrderProductEntity> cartItems;

}
