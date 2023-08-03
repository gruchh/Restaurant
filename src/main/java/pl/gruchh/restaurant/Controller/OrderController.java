package pl.gruchh.restaurant.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gruchh.restaurant.Controller.Dto.OrderDTO;
import pl.gruchh.restaurant.Controller.Dto.PizzaDTO;
import pl.gruchh.restaurant.Entity.Order;
import pl.gruchh.restaurant.Mapper.OrderMapper;
import pl.gruchh.restaurant.Service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/orders")
@RestController
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @RequestMapping()
    public ResponseEntity<List<OrderDTO>> getAllOrders() {

        List<OrderDTO> orderDTOList = orderService.getAllOrders()
                .stream()
                .map(order -> orderMapper.mapToOrderDTO(order))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(orderDTOList);
    }
}
