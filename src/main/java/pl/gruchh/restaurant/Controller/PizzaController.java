package pl.gruchh.restaurant.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gruchh.restaurant.Entity.Pizza;
import pl.gruchh.restaurant.Service.PizzaService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/pizzas")
@RestController
public class PizzaController {

    private final PizzaService pizzaService;

    @RequestMapping()
    public ResponseEntity<List<Pizza> > getAllPizzas() {

        return ResponseEntity.ok().body(pizzaService.getAllPizzas());
    }
}
