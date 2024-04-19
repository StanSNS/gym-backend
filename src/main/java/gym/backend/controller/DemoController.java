package gym.backend.controller;

import gym.backend.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class DemoController {

    private final EmailService emailService;

    @GetMapping("/send")
    public String getAllAdminData() throws MessagingException {
        emailService.sendTest();
        return "Sent";
    }

}
