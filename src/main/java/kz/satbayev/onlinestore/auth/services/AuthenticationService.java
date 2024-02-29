package kz.satbayev.onlinestore.auth.services;

import kz.satbayev.onlinestore.auth.models.entity.ApplicationUser;
import kz.satbayev.onlinestore.auth.models.entity.Role;
import kz.satbayev.onlinestore.auth.models.dto.AuthenticationResponse;
import kz.satbayev.onlinestore.auth.models.dto.RegistrationDto;
import kz.satbayev.onlinestore.auth.models.repository.RoleRepository;
import kz.satbayev.onlinestore.auth.models.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;
    private UserService userService;

    @Autowired
    public AuthenticationService(UserRepository userRepository,
                                 RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager,
                                 TokenService tokenService,
                                 UserService userService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    public AuthenticationResponse registerUser(RegistrationDto body){
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        var user = userService.save(new ApplicationUser(0, body.getUsername(), passwordEncoder.encode(body.getPassword()), authorities));
        var token = checkToken(body.getUsername(), body.getPassword());
        return new AuthenticationResponse(user.getUsername(), authorities, token);
    }

    public AuthenticationResponse loginUser(RegistrationDto body) {
        var token = checkToken(body.getUsername(), body.getPassword());
        var user = userRepository.findByUsername(body.getUsername()).get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(roleRepository.findByAuthority("USER").get());
        return new AuthenticationResponse(user.getUsername(), authorities, token);
    }

    private String checkToken(String username, String password) {

        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            return tokenService.generateJwt(auth);

        } catch(AuthenticationException e){
            return null;
        }
    }

}
