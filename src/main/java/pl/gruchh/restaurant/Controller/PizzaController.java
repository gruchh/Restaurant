package pl.gruchh.restaurant.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gruchh.restaurant.Controller.Dto.PizzaDTO;
import pl.gruchh.restaurant.Mapper.PizzaMapper;
import pl.gruchh.restaurant.Service.PizzaService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/pizzas")
@RestController
public class PizzaController {

    private final PizzaService pizzaService;
    private final PizzaMapper pizzaMapper;

    @RequestMapping()
    public ResponseEntity<List<PizzaDTO>> getAllPizzas() {

        List<PizzaDTO> pizzaDTOList = pizzaService.getAllPizzas()
                .stream()
                .map(n -> pizzaMapper.mapToPizzaDTO(n))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(pizzaDTOList);
    }
}
