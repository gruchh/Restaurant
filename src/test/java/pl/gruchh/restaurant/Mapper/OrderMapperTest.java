package pl.gruchh.restaurant.Mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.gruchh.restaurant.Controller.Dto.OrderDTO;
import pl.gruchh.restaurant.Entity.Order;
import pl.gruchh.restaurant.Entity.Pizza;
import pl.gruchh.restaurant.Service.PizzaService;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderMapperTest {

    @Mock
    private PizzaService pizzaService;

    @InjectMocks
    private OrderMapper orderMapper;

    @Test
    void shouldMapToOrderDtoWithCorrectData() {

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
        assertEquals(pizzaSet.stream().map(Pizza::getName).collect(Collectors.toSet()), orderDTO.pizzas());
        assertTrue(orderDTO.pizzas().contains("Hawaiian"));
        assertTrue(orderDTO.pizzas().contains("Salami"));
    }

    @Test
    void shouldMapToOrderDtoWithEmptyPizzas() {

        // Given
        Set<Pizza> pizzaSet = Set.of(
                Pizza.builder().name("Hawaiian").build(),
                Pizza.builder().name("Salami").build()
        );

        Order order = Order.builder()
                .id(1L)
                .username("admin")
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

    @Test
    void shouldThrowExceptionWhileMapToOrderDtoWithNull() {

        // When and Then
        assertThrows(IllegalArgumentException.class, () -> {
            orderMapper.mapToOrderDTO(null);
        });
    }

    @Test
    void shouldMapToOrderWithCorrectData() {

        // Given
        OrderDTO orderDTO = OrderDTO.builder()
                .id(133L)
                .username("admin")
                .pizzas((Set.of("Hawaiian", "Salami")))
                .build();


        Pizza hawaiian = Pizza.builder().name("Hawaiian").build();
        Pizza salami = Pizza.builder().name("Salami").build();

        when(pizzaService.getPizzaByName("Hawaiian")).thenReturn(hawaiian);
        when(pizzaService.getPizzaByName("Salami")).thenReturn(salami);

        // When
        Order order = orderMapper.mapToOrder(orderDTO);

        // Then
        assertNotNull(order);
        assertEquals(orderDTO.id(), order.getId());
        assertEquals(orderDTO.username(), order.getUsername());
        assertNotNull(order.getPizzaSet());
        assertEquals(2, order.getPizzaSet().size());
        assertTrue(order.getPizzaSet().contains(hawaiian));
        assertTrue(order.getPizzaSet().contains(salami));
    }

    @Test
    void shouldMapToOrderWithEmptyPizzas() {
        // Given
        OrderDTO orderDTO = OrderDTO.builder()
                .id(133L)
                .username("admin")
                .build();

        // When
        Order order = orderMapper.mapToOrder(orderDTO);

        // Then
        assertNotNull(order);
        assertEquals(orderDTO.id(), order.getId());
        assertEquals(orderDTO.username(), order.getUsername());
        assertNotNull(order.getPizzaSet());
        assertTrue(order.getPizzaSet().isEmpty());
    }

    @Test
    void shouldThrowExceptionWhileMapToOrderWithNullDto() {

        // When and Then
        assertThrows(IllegalArgumentException.class, () -> {
            orderMapper.mapToOrder(null);
        });
    }
}