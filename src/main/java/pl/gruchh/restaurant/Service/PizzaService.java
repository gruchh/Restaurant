package pl.gruchh.restaurant.Service;

import pl.gruchh.restaurant.Entity.Pizza;

import java.util.List;

public interface PizzaService {
    void savePizzaList(List<Pizza> pizzaList);

    List<Pizza> getAllPizzas();
    Pizza getPizzaByName(String name);

}
