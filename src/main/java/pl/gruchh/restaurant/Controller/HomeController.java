package pl.gruchh.restaurant.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gruchh.restaurant.Entity.Ingredient;
import pl.gruchh.restaurant.Entity.Pizza;
import pl.gruchh.restaurant.Service.IngredientService;
import pl.gruchh.restaurant.Service.PizzaService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class HomeController {

    private final PizzaService pizzaService;
    private final IngredientService ingredientService;

    @EventListener(ApplicationReadyEvent.class)
    public void runOnStart() {

        Ingredient ing1 = new Ingredient();
        Ingredient ing2 = new Ingredient();
        ing1.setName("Bukak");
        ing2.setName("Cukinia");
        ingredientService.saveIngredientList(Arrays.asList(ing1, ing2));

        Pizza pizza1 = new Pizza();
        Pizza pizza2 = new Pizza();
        pizza1.setName("Margarita");
        pizza1.setCost(new BigDecimal(23));
        pizza2.setName("Salami");
        pizza2.setCost(new BigDecimal(26));

        pizza1.setIngredientSet(Set.of(ing1));
        pizza2.setIngredientSet(Set.of(ing1, ing2));

        ing1.setPizzaSet(Set.of(pizza1, pizza2));
        ing2.setPizzaSet(Set.of(pizza2));
        pizzaService.savePizzaList(Arrays.asList(pizza1, pizza2));

    }

}
