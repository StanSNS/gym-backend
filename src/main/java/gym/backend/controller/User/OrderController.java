package gym.backend.controller.User;

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
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Long> receiveOrder(@RequestBody OrderDTO orderDTO) throws MessagingException {
        return new ResponseEntity<>(orderService.addOrder(orderDTO), HttpStatus.OK);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<CitySpeedyDTO>> getAllAddresses() {
        return new ResponseEntity<>(orderService.getAllSpeedyAddresses(), HttpStatus.OK);
    }

    @GetMapping("/recover")
    public ResponseEntity<String> recoverAllOrderInfo(@RequestParam String email) throws MessagingException {
        return orderService.recoverOrdersAndSendEmail(email);
    }

    @GetMapping("/number")
    public ResponseEntity<String> findOrderByNumber(@RequestParam Long number) throws MessagingException {
        return orderService.findOrderAndSendEmail(number);
    }
}
