package gym.backend.init.Products;

import gym.backend.exception.ResourceNotFoundException;
import gym.backend.models.entity.TasteColor;
import gym.backend.repository.TasteColorEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class TasteColorsInit {

    private final TasteColorEntityRepository tasteColorEntityRepository;

    @CacheEvict(value = "allSellableProducts", allEntries = true)
    public void startInit() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("TasteColors.txt");
        if (inputStream == null) {
            throw new ResourceNotFoundException();
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<TasteColor> tasteColorsToSave = new ArrayList<>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String name = line.split(" ")[0];
            String color = line.split(" ")[1];

            if (!tasteColorEntityRepository.existsByNameIgnoreCase(name)) {
                TasteColor tasteColor = new TasteColor();
                tasteColor.setName(name);
                tasteColor.setColor(color);
                tasteColorsToSave.add(tasteColor);
            }
        }
        tasteColorEntityRepository.saveAll(tasteColorsToSave);
    }
}
