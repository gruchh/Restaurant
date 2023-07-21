package pl.gruchh.restaurant.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "INGREDIENTS")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal cost;
    private boolean isAvailable;

    @ManyToMany(mappedBy = "ingredientSet")
    private Set<Pizza> pizzaSet;

}
