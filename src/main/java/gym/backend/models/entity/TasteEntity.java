package gym.backend.models.entity;

import gym.backend.models.entity.BaseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Table(name = "tastes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TasteEntity extends BaseEntity {

    @Column
    private String tasteId;

    @Column
    private String name;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TasteEntity that = (TasteEntity) o;
//        return Objects.equals(tasteId, that.tasteId) && Objects.equals(name, that.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(tasteId, name);
//    }
}
