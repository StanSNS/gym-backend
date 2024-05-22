package gym.backend.init.Products;

import gym.backend.models.entity.TasteColor;
import gym.backend.repository.TasteColorEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TasteColorsInit {

    private final TasteColorEntityRepository tasteColorEntityRepository;

    public void startInit() throws IOException {
        System.out.println("START taste-color-execute...");
        String filePath = "src/main/resources/TasteColors.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String name = line.split(" ")[0];
            String color = line.split(" ")[1];

            if (!tasteColorEntityRepository.existsByNameIgnoreCase(name)) {
                TasteColor tasteColor = new TasteColor();
                tasteColor.setName(name);
                tasteColor.setColor(color);
                tasteColorEntityRepository.save(tasteColor);
            }
        }
        System.out.println("END taste-color-execute...");
    }
}