package pl.gruchh.restaurant.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.gruchh.restaurant.Entity.Order;
import pl.gruchh.restaurant.Repository.OrderRepository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public void saveOrderList(List<Order> orderList) {
        orderRepository.saveAll(orderList);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
