package pl.gruchh.restaurant.Service;

import pl.gruchh.restaurant.Entity.Order;

import java.util.List;
import java.util.Set;

public interface OrderService {

    void saveOrderSet(Set<Order> orderList);

    List<Order> getAllOrders();
}
