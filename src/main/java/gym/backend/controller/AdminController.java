package gym.backend.controller;

import gym.backend.models.DTO.Admin.Order.AdminOrderDTO;
import gym.backend.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${my.url}")
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<List<AdminOrderDTO>> getAllAdminData() {
        return new ResponseEntity<>(adminService.getAllOrdersForAdminPage(), HttpStatus.OK);
    }
}
