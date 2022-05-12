package coherent.practica.candyshop.repository;


import coherent.practica.candyshop.model.Candy;
import coherent.practica.candyshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CandyRepository extends JpaRepository<Candy,String> {
    Optional<Candy> findByName(String name);
    List<Candy> getAllByCategory(Category category);
}
