package coherent.practica.candyshop.service;

import coherent.practica.candyshop.config.JwtTokenGenerator;
import coherent.practica.candyshop.exception.InvalidLoginDetailsException;
import coherent.practica.candyshop.exception.UserAlreadyAddedException;
import coherent.practica.candyshop.exception.UserNotFoundException;
import coherent.practica.candyshop.model.CustomUserDetails;
import coherent.practica.candyshop.model.LoginRequest;
import coherent.practica.candyshop.model.LoginResponse;
import coherent.practica.candyshop.model.User;
import coherent.practica.candyshop.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    JwtTokenGenerator jwtTokenGenerator;

    public AuthenticationService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, JwtTokenGenerator jwtTokenGenerator) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(()-> new UserNotFoundException(loginRequest.getUsername()));
        if (!bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
            throw new InvalidLoginDetailsException(loginRequest.getUsername());

        CustomUserDetails customUserDetails = new CustomUserDetails(user);

        return new LoginResponse(jwtTokenGenerator.generateTokenWithPrefix(customUserDetails));
    }

    public User register(LoginRequest loginRequest) {
        userRepository.findByUsername(loginRequest.getUsername()).ifPresent(s -> {
            throw new UserAlreadyAddedException(loginRequest.getUsername());
        });
        User user = new User();
        user.setUsername(loginRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(loginRequest.getPassword()));
        user.setRole("ROLE_USER");
        return userRepository.save(user);
    }
}
