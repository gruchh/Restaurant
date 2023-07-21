package pl.gruchh.restaurant.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.gruchh.restaurant.Entity.Pizza;
import pl.gruchh.restaurant.Repository.PizzaRepository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }
}
