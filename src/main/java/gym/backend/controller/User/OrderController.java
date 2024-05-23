package gym.backend.controller.User;

import gym.backend.models.DTO.Order.DeliveryPriceReqDTO;
import gym.backend.models.DTO.Order.OrderDTO;
import gym.backend.models.DTO.SpeedyOffices.CitySpeedyDTO;
import gym.backend.service.OrderService;
import jakarta.mail.MessagingException;
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
    public ResponseEntity<Long> receiveOrder(@RequestBody OrderDTO orderDTO) throws MessagingException {
        return new ResponseEntity<>(orderService.addOrder(orderDTO), HttpStatus.OK);
    }

    @PostMapping(GET_DELIVERY_PRICE)
    public ResponseEntity<Long> getDeliveryPrice(@RequestBody DeliveryPriceReqDTO deliveryPriceDTOReq) {

        System.out.println(deliveryPriceDTOReq.getOfficeID());
        System.out.println(deliveryPriceDTOReq.getAmountWithoutDelivery());
        System.out.println(deliveryPriceDTOReq.getTotalWeight());


        orderService.getDeliveryPrice(deliveryPriceDTOReq);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(GET_ALL_ADDRESSES)
    public ResponseEntity<List<CitySpeedyDTO>> getAllAddresses() {
        return new ResponseEntity<>(orderService.getAllSpeedyAddresses(), HttpStatus.OK);
    }

    @GetMapping(RECOVER_ALL_ORDER_INFO)
    public ResponseEntity<String> recoverAllOrderInfo(@RequestParam String email) throws MessagingException {
        return orderService.recoverOrdersAndSendEmail(email);
    }

    @GetMapping(FIND_ORDER_BY_NUMBER)
    public ResponseEntity<String> findOrderByNumber(@RequestParam Long number) throws MessagingException {
        return orderService.findOrderAndSendEmail(number);
    }
}
