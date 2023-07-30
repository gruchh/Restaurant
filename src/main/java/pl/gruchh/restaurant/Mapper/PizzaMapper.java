package pl.gruchh.restaurant.Mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gruchh.restaurant.Controller.Dto.PizzaDTO;
import pl.gruchh.restaurant.Entity.Ingredient;
import pl.gruchh.restaurant.Entity.Pizza;
import pl.gruchh.restaurant.Service.IngredientService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PizzaMapper {

    private final IngredientService ingredientService;

    public PizzaDTO mapToPizzaDTO(Pizza pizza) {

        Set<String> ingredientSet;

        if (pizza.getIngredientSet() == null) {
            ingredientSet = new HashSet<>();

        } else {
            ingredientSet = pizza.getIngredientSet().stream().map(Ingredient::getName).collect(Collectors.toSet());
        }

        return PizzaDTO.builder()
                .id(pizza.getId())
                .name(pizza.getName())
                .cost(pizza.getCost())
                .ingredients(ingredientSet)
                .build();
    }

    public Pizza mapToPizza(PizzaDTO pizzaDTO) {

        Set<Ingredient> ingredientSet;

        if (pizzaDTO.ingredients() == null) {
            ingredientSet = new HashSet<>();
        } else {
            ingredientSet =
                    pizzaDTO.ingredients().stream().map(ingredientService::getIngredientByName).collect(Collectors.toSet());
        }

        return Pizza.builder()
                .name(pizzaDTO.name())
                .cost(pizzaDTO.cost())
                .ingredientSet(ingredientSet)
                .build();
    }


}
