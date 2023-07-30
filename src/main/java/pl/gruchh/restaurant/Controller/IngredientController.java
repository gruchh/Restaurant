package pl.gruchh.restaurant.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gruchh.restaurant.Controller.Dto.PizzaDTO;
import pl.gruchh.restaurant.Entity.Ingredient;
import pl.gruchh.restaurant.Service.IngredientService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/ingredients")
@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    @RequestMapping()
    public ResponseEntity<List<Ingredient>> getAllIngredients() {

        return ResponseEntity.ok().body(ingredientService.getAllIngredients());
    }

}
