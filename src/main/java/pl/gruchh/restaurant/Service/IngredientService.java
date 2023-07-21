package pl.gruchh.restaurant.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gruchh.restaurant.Entity.Ingredient;
import pl.gruchh.restaurant.Repository.IngredientRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
}
