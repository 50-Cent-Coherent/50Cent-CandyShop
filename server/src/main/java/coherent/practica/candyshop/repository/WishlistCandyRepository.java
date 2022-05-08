package coherent.practica.candyshop.repository;

import coherent.practica.candyshop.model.Candy;
import coherent.practica.candyshop.model.OrderCandy;
import coherent.practica.candyshop.model.WishlistCandy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface WishlistCandyRepository extends JpaRepository<WishlistCandy,String> {
    void deleteByCandy(Candy candy);
}
