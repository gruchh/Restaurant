package pl.gruchh.restaurant.Mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gruchh.restaurant.Controller.Dto.IngredientDTO;
import pl.gruchh.restaurant.Entity.Ingredient;

@Component
@AllArgsConstructor
public class IngredientMapper {

    public IngredientDTO mapToIngredientDTO(Ingredient ingredient) {

        if (ingredient == null) {
            throw new IllegalArgumentException("ingredient cannot be null");
        }

        return IngredientDTO.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .description(ingredient.getDescription())
                .cost(ingredient.getCost())
                .isAvailable(ingredient.isAvailable())
                .build();
    }

    public Ingredient mapToIngredient(IngredientDTO ingredientDTO) {

        if (ingredientDTO == null) {
            throw new IllegalArgumentException("ingredientDTO cannot be null");
        }

        return Ingredient.builder()
                .id(ingredientDTO.id())
                .name(ingredientDTO.name())
                .description(ingredientDTO.description())
                .cost(ingredientDTO.cost())
                .isAvailable(ingredientDTO.isAvailable())
                .build();
    }
}