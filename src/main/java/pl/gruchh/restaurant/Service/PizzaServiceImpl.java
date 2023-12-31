package pl.gruchh.restaurant.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.gruchh.restaurant.Entity.Pizza;
import pl.gruchh.restaurant.Repository.PizzaRepository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PizzaServiceImpl implements  PizzaService{

    private final PizzaRepository pizzaRepository;

    public void savePizzaList(List<Pizza> pizzaList) {
        pizzaRepository.saveAll(pizzaList);
    }

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaByName(String name) {

        return pizzaRepository.findByName(name);
    }



}
