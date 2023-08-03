package pl.gruchh.restaurant.Mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.gruchh.restaurant.Controller.Dto.IngredientDTO;
import pl.gruchh.restaurant.Entity.Ingredient;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class IngredientMapperTest {

    @InjectMocks
    private IngredientMapper ingredientMapper;

    @Test
    void shouldMapToIngredientDTOWithNullDto() {

        //Given
        Ingredient ingredient = Ingredient.builder()
                .id(1L)
                .name("Cheese")
                .description("Mozarella")
                .cost(new BigDecimal("23.4"))
                .isAvailable(true)
                .build();
        //When
        IngredientDTO ingredientDTO = ingredientMapper.mapToIngredientDTO(ingredient);

        //Then
        assertEquals(ingredient.getId(), ingredientDTO.id());
        assertEquals(ingredient.getName(), ingredientDTO.name());
        assertEquals(ingredient.getDescription(), ingredientDTO.description());
        assertEquals(ingredient.getCost(), ingredientDTO.cost());
        assertEquals(ingredient.isAvailable(), ingredientDTO.isAvailable());
    }

    @Test
    void shouldThrowExceptionWhileMapToIngredientWithNullDto() {

        // When and Then
        assertThrows(IllegalArgumentException.class, () -> {
            ingredientMapper.mapToIngredient(null);
        });
    }

    @Test
    void shouldMapToIngredientWithCorrectData() {

        //Given
        IngredientDTO ingredientDTO = IngredientDTO.builder()
                .id(1L)
                .name("Cheese")
                .description("Mozarella")
                .cost(new BigDecimal("23.4"))
                .isAvailable(true)
                .build();

        // When
        Ingredient ingredient = ingredientMapper.mapToIngredient(ingredientDTO);

        // Then
        assertEquals(ingredientDTO.id(), ingredient.getId());
        assertEquals(ingredientDTO.name(), ingredient.getName());
        assertEquals(ingredientDTO.description(), ingredient.getDescription());
        assertEquals(ingredientDTO.cost(), ingredient.getCost());
        assertEquals(ingredientDTO.isAvailable(), ingredient.isAvailable());
    }

    @Test
    void shouldMapToIngredientWithNull() {

        // When and Then
        assertThrows(IllegalArgumentException.class, () -> {
            ingredientMapper.mapToIngredientDTO(null);
        });
    }

}
