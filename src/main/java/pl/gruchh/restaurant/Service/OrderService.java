package pl.gruchh.restaurant.Service;

import pl.gruchh.restaurant.Controller.Dto.OrderCreateDTO;
import pl.gruchh.restaurant.Controller.Dto.OrderDTO;
import pl.gruchh.restaurant.Entity.Order;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

public interface OrderService {

    void saveOrderSet(Set<Order> orderList);

    List<Order> getAllOrders();

    OrderDTO createOrder(@Valid OrderCreateDTO orderCreateDTO);


}
