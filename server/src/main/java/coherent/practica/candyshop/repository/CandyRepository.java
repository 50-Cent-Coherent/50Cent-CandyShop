package coherent.practica.candyshop.repository;


import coherent.practica.candyshop.model.Candy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandyRepository extends JpaRepository<Candy,String> {

}
