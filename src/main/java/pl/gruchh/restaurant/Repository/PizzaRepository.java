package pl.gruchh.restaurant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gruchh.restaurant.Entity.Ingredient;
import pl.gruchh.restaurant.Entity.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    Pizza findByName(String name);
}
