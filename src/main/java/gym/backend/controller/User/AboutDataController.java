package gym.backend.controller.User;

import gym.backend.models.DTO.AboutDataDto;
import gym.backend.service.AboutDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("test-new-data")
    public ResponseEntity<String> testNewController() {
        return new ResponseEntity<>("This is modified new code again...", HttpStatus.OK);
    }
}
