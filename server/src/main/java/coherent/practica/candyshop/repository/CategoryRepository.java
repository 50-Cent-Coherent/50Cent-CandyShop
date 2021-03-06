package coherent.practica.candyshop.repository;


import coherent.practica.candyshop.model.Candy;
import coherent.practica.candyshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
    Optional<Category> findByName(String name);

}
