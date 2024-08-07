package gym.backend.controller.User;

import gym.backend.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static gym.backend.consts.Urls.UserControllerUrlPaths.SEND_EMAIL;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${user.frontend.base.url}")
@RequestMapping
public class OtherController {

    private final EmailService emailService;

    @PostMapping(SEND_EMAIL)
    @Valid
    public ResponseEntity<String> sendEmail(@NotBlank @Email @RequestParam String email,
                                            @NotBlank @RequestParam String title,
                                            @NotBlank @RequestParam String content) {
        try {
            emailService.sendRequestEmail(email, title, content);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
