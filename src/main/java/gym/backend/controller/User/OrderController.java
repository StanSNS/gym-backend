package gym.backend.controller.User;

import gym.backend.models.DTO.Order.DeliveryPriceReqDTO;
import gym.backend.models.DTO.Order.OrderDTO;
import gym.backend.models.DTO.SpeedyOffices.CitySpeedyDTO;
import gym.backend.service.OrderService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static gym.backend.consts.Urls.UserControllerUrlPaths.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${user.frontend.base.url}")
@RequestMapping
public class OrderController {

    private final OrderService orderService;

    @PostMapping(RECEIVE_ORDER)
    public ResponseEntity<Long> receiveOrder(@Valid @RequestBody OrderDTO orderDTO) throws MessagingException {
        return new ResponseEntity<>(orderService.addOrder(orderDTO), HttpStatus.OK);
    }

    @PostMapping(GET_DELIVERY_PRICE)
    public ResponseEntity<?> getDeliveryPrice(@Valid @RequestBody DeliveryPriceReqDTO deliveryPriceDTOReq) {
        return orderService.getDeliveryPrice(deliveryPriceDTOReq);
    }

    @GetMapping(GET_ALL_ADDRESSES)
    public ResponseEntity<List<CitySpeedyDTO>> getAllAddresses() {
        return new ResponseEntity<>(orderService.getAllSpeedyAddresses(), HttpStatus.OK);
    }

    @GetMapping(RECOVER_ALL_ORDER_INFO)
    @Valid
    public ResponseEntity<String> recoverAllOrderInfo(@Email @NotBlank @RequestParam String email) throws MessagingException {
        return orderService.recoverOrdersAndSendEmail(email);
    }

    @GetMapping(FIND_ORDER_BY_NUMBER)
    @Valid
    public ResponseEntity<String> findOrderByNumber(@Positive @RequestParam Long number) {
        try {
            return orderService.findOrderAndSendEmail(number);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
