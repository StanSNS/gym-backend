package gym.backend.models.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "sizes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SizeEntity extends BaseEntity {
    private String sizeId;
    private String name;
    private String ean;
}



