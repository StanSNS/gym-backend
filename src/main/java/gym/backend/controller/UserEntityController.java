package gym.backend.controller;

import gym.backend.entity.UserEntity;
import gym.backend.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "${my.url}")
@RequiredArgsConstructor
public class UserEntityController {

    @Value("${my.url}")
    private String testURL;

    private final UserEntityRepository userEntityRepository;

    @PostMapping("/addUser")
    public String addUser() {
        return "User added.";
    }

    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }

    @GetMapping("test")
    public String testUrl() {
        return testURL;
    }
}
