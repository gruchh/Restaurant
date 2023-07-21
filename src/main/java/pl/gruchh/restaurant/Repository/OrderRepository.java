package pl.gruchh.restaurant.Repository;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gruchh.restaurant.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
