package gym.backend.models.json.ProductRequest.Taste;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TasteJSONData {
    private List<TasteJSONList> data;
}
