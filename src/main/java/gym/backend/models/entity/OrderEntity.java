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
    private Long officeID;

    @Column
    private String postCode;

    @Column
    private Double totalWeight;

    @Enumerated
    private OrderStatus orderStatus;

    @Column
    private Double totalAmount;

    @Column
    private Double totalSaving;

    @Column
    private Integer productCount;

    @Column
    private Double deliveryPrice;

    @Column
    private String speedyDeliveryId;

    @Column
    private String pickupDate;

    @Column
    private String deliveryDeadline;

    @Column
    private Boolean isUserCalled;

    @ManyToMany
    private List<OrderProductEntity> cartItems;

}
