package kz.satbayev.onlinestore.auth.controller;

import kz.satbayev.onlinestore.auth.models.dto.AuthenticationResponse;
import kz.satbayev.onlinestore.auth.models.dto.RegistrationDto;
import kz.satbayev.onlinestore.auth.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public AuthenticationResponse registerUser(@RequestBody RegistrationDto body){
        return authenticationService.registerUser(body);
    }

    @PostMapping("/login")
    public AuthenticationResponse loginUser(@RequestBody RegistrationDto body){
        return authenticationService.loginUser(body);
    }
}
