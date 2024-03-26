package gym.backend.models.json.Taste;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TasteJSONData {
    private List<TasteJSONList> data;
}
