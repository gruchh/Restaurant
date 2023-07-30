package pl.gruchh.restaurant.Mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.gruchh.restaurant.Controller.Dto.PizzaDTO;
import pl.gruchh.restaurant.Entity.Pizza;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
class PizzaMapperTest {

    @Autowired
    private PizzaMapper pizzaMapper;

    @Test
    void whenMapToPizzaDTO() {

        //set
        Pizza pizza = Pizza.builder()
                .name("Salami")
                .cost(BigDecimal.TEN)
                .build();

        PizzaDTO pizzaDTO = PizzaDTO.builder()
                .name("Salami")
                .cost(BigDecimal.TEN)
                .build();

        //when
        PizzaDTO result = pizzaMapper.mapToPizzaDTO(pizza);

        // then
        assertEquals(pizzaDTO.name(), result.name());
        assertEquals(pizzaDTO.cost(), result.cost());

    }

    @Test
    void mapToPizza() {
        //set
        Pizza pizza = Pizza.builder()
                .name("Salami")
                .cost(BigDecimal.TEN)
                .build();

        PizzaDTO pizzaDTO = PizzaDTO.builder()
                .name("Salami")
                .cost(BigDecimal.TEN)
                .build();

        //when
        Pizza result = pizzaMapper.mapToPizza(pizzaDTO);

        //then
        assertEquals(pizza.getName(), result.getName());
        assertEquals(pizza.getCost(), result.getCost());
    }
}