package pl.gruchh.restaurant.Mapper;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import pl.gruchh.restaurant.Controller.Dto.OrderDTO;
import pl.gruchh.restaurant.Entity.Order;
import pl.gruchh.restaurant.Entity.Pizza;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {

    @InjectMocks
    private OrderMapper orderMapper;

    @Test
    void testMapToOrderDTOWithPizzas() {

        // Given
        Set<Pizza> pizzaSet = Set.of(
                Pizza.builder().name("Hawaiian").build(),
                Pizza.builder().name("Salami").build()
        );

        Order order = Order.builder()
                .username("admin")
                .pizzaSet(pizzaSet)
                .build();

        // When
        OrderDTO orderDTO = orderMapper.mapToOrderDTO(order);

        // Then
        assertNotNull(orderDTO);
        assertEquals(order.getId(), orderDTO.id());
        assertEquals(order.getUsername(), orderDTO.username());
        assertNotNull(orderDTO.pizzas());
        assertEquals(2, orderDTO.pizzas().size());
        assertTrue(orderDTO.pizzas().contains("Hawaii"));
        assertTrue(orderDTO.pizzas().contains("Salami"));
    }

    @Test
    void testMapToOrderDTOWithNullPizzas() {

        // Given
        Set<Pizza> pizzaSet = Set.of(
                Pizza.builder().name("Hawaiian").build(),
                Pizza.builder().name("Salami").build()
        );

        Order order = Order.builder()
                .username("admin")
                .pizzaSet(pizzaSet)
                .build();
        // When
        OrderDTO orderDTO = orderMapper.mapToOrderDTO(order);

        // Then
        assertNotNull(orderDTO);
        assertEquals(order.getId(), orderDTO.id());
        assertEquals(order.getUsername(), orderDTO.username());
        assertNotNull(orderDTO.pizzas());
        assertTrue(orderDTO.pizzas().isEmpty());
    }

}