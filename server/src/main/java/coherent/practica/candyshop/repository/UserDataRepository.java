package coherent.practica.candyshop.repository;

import coherent.practica.candyshop.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData,String> {


}
