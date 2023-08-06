package pl.gruchh.restaurant.Controller.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public record OrderCreateDTO(@NotBlank @Size(max = 20) String username, Set<String> pizzas) {
}
