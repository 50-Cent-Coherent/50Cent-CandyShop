package coherent.practica.candyshop.repository;

import coherent.practica.candyshop.model.WishlistCandy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistCandyRepository extends JpaRepository<WishlistCandy,String> {
}
