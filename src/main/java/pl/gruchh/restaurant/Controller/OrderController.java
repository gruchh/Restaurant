package pl.gruchh.restaurant.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gruchh.restaurant.Entity.Order;
import pl.gruchh.restaurant.Service.OrderService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    @RequestMapping()
    public ResponseEntity<List<Order>> getAllOrders() {

        return ResponseEntity.ok().body(orderService.getAllOrders());
    }
}
