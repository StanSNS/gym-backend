package gym.backend.models.json.ProductRequest.Taste;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TasteJSONList {
    private List<TasteJSON> taste;
}
