package pl.gruchh.restaurant.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.gruchh.restaurant.Entity.Order;
import pl.gruchh.restaurant.Repository.OrderRepository;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Repository
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public void saveOrderSet(Set<Order> orderList) {
        orderRepository.saveAll(orderList);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
