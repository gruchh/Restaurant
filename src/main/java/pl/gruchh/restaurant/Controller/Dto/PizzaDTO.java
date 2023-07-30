package pl.gruchh.restaurant.Controller.Dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.Set;

@Builder
public record PizzaDTO(Long id, String name, BigDecimal cost, Set<String> ingredients) {
}
