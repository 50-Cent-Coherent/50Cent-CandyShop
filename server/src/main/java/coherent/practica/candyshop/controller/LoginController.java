package coherent.practica.candyshop.controller;

import coherent.practica.candyshop.model.LoginRequest;
import coherent.practica.candyshop.model.LoginResponse;
import coherent.practica.candyshop.model.User;
import coherent.practica.candyshop.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class LoginController {
    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public LoginResponse requestLogin(@RequestBody LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/register")
    User newUser(@RequestBody LoginRequest loginRequest) throws NoSuchAlgorithmException {
        return authenticationService.register(loginRequest);
    }
}
