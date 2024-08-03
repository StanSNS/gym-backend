package gym.backend.controller.User;

import gym.backend.models.DTO.AboutDataDto;
import gym.backend.models.entity.TasteColor;
import gym.backend.service.AboutDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;

import static gym.backend.consts.Urls.UserControllerUrlPaths.ABOUT_DATA;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${user.frontend.base.url}")
@RequestMapping
public class AboutDataController {

    private final AboutDataService aboutDataService;

    @GetMapping(ABOUT_DATA)
    public ResponseEntity<AboutDataDto> getAllAboutData() {
        return new ResponseEntity<>(aboutDataService.getAboutData(), HttpStatus.OK);
    }

    @GetMapping("test")
    public ResponseEntity<?> testFile() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("TasteColors.txt");
            if (inputStream == null) {
                return new ResponseEntity<>("File not found.", HttpStatus.OK);
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            ArrayList<TasteColor> tasteColorsToSave = new ArrayList<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String name = line.split(" ")[0];
                String color = line.split(" ")[1];
                TasteColor tasteColor = new TasteColor();
                tasteColor.setName(name);
                tasteColor.setColor(color);
                tasteColorsToSave.add(tasteColor);
            }
            return new ResponseEntity<>(tasteColorsToSave, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Reading file lines failed.", HttpStatus.OK);
        }
    }
}
