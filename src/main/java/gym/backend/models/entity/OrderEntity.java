package gym.backend.models.entity;

import gym.backend.models.enums.OrderStatus;
import gym.backend.models.entity.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "orders")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity extends BaseEntity {

    @Column
    private Long randomNumber;

    @Column
    private LocalDateTime date;

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
    private String officeAddress;

    @Column
    private String postCode;

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

    @Enumerated
    private OrderStatus orderStatus;

    @Column
    private Double totalAmount;

    @Column
    private Integer productCount;

    @Column
    private Double deliveryPrice;

    @ManyToMany
    private List<OrderProductEntity> cartItems;

}
