package gym.backend.entity;


import gym.backend.entity.BaseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name ="users")
@Entity
@Data
public class UserEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String email;

}

