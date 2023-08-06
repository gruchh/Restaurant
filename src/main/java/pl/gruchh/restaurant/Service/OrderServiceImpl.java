package pl.gruchh.restaurant.Service;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;
import pl.gruchh.restaurant.Controller.Dto.OrderCreateDTO;
import pl.gruchh.restaurant.Controller.Dto.OrderDTO;
import pl.gruchh.restaurant.Entity.Order;
import pl.gruchh.restaurant.Mapper.OrderMapper;
import pl.gruchh.restaurant.Repository.OrderRepository;
import pl.gruchh.restaurant.Repository.PizzaRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;
    private final OrderMapper orderMapper;

    public void saveOrderSet(Set<Order> orderList) {
        orderRepository.saveAll(orderList);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderDTO createOrder(OrderCreateDTO orderCreateDTO) {

        Order orderToSave = Order.builder()
                .username(orderCreateDTO.username())
                .pizzaSet(orderCreateDTO.pizzas().stream().map(n -> pizzaRepository.findByName(n)).collect(Collectors.toSet()))
                .isFinished(false)
                .build();

        Order savedOrder = orderRepository.save(orderToSave);
        return orderMapper.mapToOrderDTO(savedOrder);
    }

}
