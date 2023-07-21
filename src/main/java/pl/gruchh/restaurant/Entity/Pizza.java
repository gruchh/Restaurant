package pl.gruchh.restaurant.Entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@RequiredArgsConstructor
@Entity(name = "PIZZAS")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal cost;

    @ManyToMany
    @JoinTable(
            name = "pizza_ingredient",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredientSet;

    @ManyToMany(mappedBy = "pizzaSet")
    private Set<Order> orderSet;


}
