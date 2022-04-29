package coherent.practica.candyshop.repository;

import coherent.practica.candyshop.model.Candy;
import coherent.practica.candyshop.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist,String> {
}
