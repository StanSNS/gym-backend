package gym.backend.controller;

import gym.backend.models.DTO.OrderDTO;
import gym.backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${my.url}")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("order")
    public ResponseEntity<String> receiveOrder(@RequestBody OrderDTO orderDTO) {
        orderService.addOrder(orderDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
