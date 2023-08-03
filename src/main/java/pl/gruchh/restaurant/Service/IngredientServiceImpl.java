package pl.gruchh.restaurant.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gruchh.restaurant.Entity.Ingredient;
import pl.gruchh.restaurant.Repository.IngredientRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public void saveIngredientList(List<Ingredient> ingredientList) {
        ingredientRepository.saveAll(ingredientList);
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredientByName(String name) {

        return ingredientRepository.findByName(name);
    }
}
