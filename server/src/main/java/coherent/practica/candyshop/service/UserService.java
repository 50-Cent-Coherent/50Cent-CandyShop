package coherent.practica.candyshop.service;

import coherent.practica.candyshop.exception.UserNotFoundException;
import coherent.practica.candyshop.model.User;
import coherent.practica.candyshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new UserNotFoundException(username));

    }


}
