package pl.gruchh.restaurant.Mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gruchh.restaurant.Controller.Dto.OrderDTO;
import pl.gruchh.restaurant.Entity.Order;
import pl.gruchh.restaurant.Entity.Pizza;
import pl.gruchh.restaurant.Service.PizzaService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OrderMapper {

    private final PizzaService pizzaService;

    public OrderDTO mapToOrderDTO(Order order) {

        if (order == null) {
            throw new IllegalArgumentException("order cannot be null");
        }

        Set<String> pizzaSet;

        if (order.getPizzaSet() == null) {
            pizzaSet = new HashSet<>();

        } else {
            pizzaSet = order.getPizzaSet().stream().map(Pizza::getName).collect(Collectors.toSet());
        }

        return OrderDTO.builder()
                .id(order.getId())
                .username(order.getUsername())
                .pizzas(pizzaSet)
                .build();
    }

    public Order mapToOrder(OrderDTO orderDTO) {

        if (orderDTO == null) {
            throw new IllegalArgumentException("orderDto cannot be null");
        }

        Set<Pizza> pizzaSet;

        if (orderDTO.pizzas() == null) {
            pizzaSet = new HashSet<>();
        } else {
            pizzaSet =
                    orderDTO.pizzas().stream().map(pizzaService::getPizzaByName).collect(Collectors.toSet());
        }

        return Order.builder()
                .id(orderDTO.id())
                .username(orderDTO.username())
                .pizzaSet(pizzaSet)
                .build();
    }


}
