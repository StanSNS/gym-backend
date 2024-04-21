package gym.backend.controller;

import gym.backend.models.DTO.OrderDTO;
import gym.backend.models.DTO.SpeedyOffices.CitySpeedyDTO;
import gym.backend.service.OrderService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${my.url}")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("order")
    public ResponseEntity<Long> receiveOrder(@RequestBody OrderDTO orderDTO) throws MessagingException {
        return new ResponseEntity<>(orderService.addOrder(orderDTO), HttpStatus.OK);
    }

    @GetMapping("order/addresses")
    public ResponseEntity<List<CitySpeedyDTO>> getAllAddresses() {
        return new ResponseEntity<>(orderService.getAllSpeedyAddresses(), HttpStatus.OK);
    }
}
