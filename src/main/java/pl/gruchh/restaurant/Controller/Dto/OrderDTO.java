package pl.gruchh.restaurant.Controller.Dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record OrderDTO(Long id, String username, Set<String> pizzas) {
}
