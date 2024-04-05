package gym.backend.init;

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
        if (tasteColorEntityRepository.count() == 0) {
            System.out.println("Start reading from txt...");

            String filePath = "src/main/resources/TasteColors.txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                TasteColor tasteColor = new TasteColor();
                tasteColor.setName(line.split(" ")[0]);
                tasteColor.setColor(line.split(" ")[1]);
                tasteColorEntityRepository.save(tasteColor);
            }
            System.out.println("Taste colors have been saved... " + tasteColorEntityRepository.count());
        } else {
            System.out.println("Taste Colors are filled already - skipping... " + tasteColorEntityRepository.count());
        }
    }
}
