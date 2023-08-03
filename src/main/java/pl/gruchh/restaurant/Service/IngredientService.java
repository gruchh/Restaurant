package pl.gruchh.restaurant.Service;

import pl.gruchh.restaurant.Entity.Ingredient;

import java.util.List;

public interface IngredientService {

    void saveIngredientList(List<Ingredient> ingredientList);
    List<Ingredient> getAllIngredients();
    Ingredient getIngredientByName(String name);
}
