package pl.gruchh.restaurant.Controller.Dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record IngredientDTO(Long id, String name, String description, BigDecimal cost, boolean isAvailable) {

}
