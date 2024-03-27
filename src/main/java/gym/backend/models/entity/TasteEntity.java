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

    @Column(unique = true, nullable = false)
    private String silaTasteID;

    @Column(nullable = false)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TasteEntity that = (TasteEntity) o;
        return Objects.equals(silaTasteID, that.silaTasteID) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(silaTasteID, name);
    }
}
