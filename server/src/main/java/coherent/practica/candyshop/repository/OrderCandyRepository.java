package coherent.practica.candyshop.repository;

import coherent.practica.candyshop.model.OrderCandy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCandyRepository extends JpaRepository<OrderCandy,String> {
}
