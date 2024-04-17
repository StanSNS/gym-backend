package gym.backend.controller;

import gym.backend.models.DTO.SpeedyOffices.CitySpeedyDTO;
import gym.backend.models.DTO.OrderDTO;
import gym.backend.service.OrderService;
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
    public ResponseEntity<Long> receiveOrder(@RequestBody OrderDTO orderDTO) throws InterruptedException {
        Thread.sleep(10000);
        return new ResponseEntity<>(orderService.addOrder(orderDTO), HttpStatus.OK);
    }

    @GetMapping("order/addresses")
    public ResponseEntity<List<CitySpeedyDTO>> getAllAddresses() throws InterruptedException {
        Thread.sleep(10000);
        return new ResponseEntity<>(orderService.getAllSpeedyAddresses(), HttpStatus.OK);
    }
}
