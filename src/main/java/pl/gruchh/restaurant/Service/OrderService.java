package pl.gruchh.restaurant.Service;

import pl.gruchh.restaurant.Entity.Order;

import java.util.List;

public interface OrderService {

    void saveOrderList(List<Order> orderList);
    List<Order> getAllOrders();
}
