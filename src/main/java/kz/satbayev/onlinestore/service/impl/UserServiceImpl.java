package kz.satbayev.onlinestore.service.impl;


import kz.satbayev.onlinestore.model.entity.Roles;
import kz.satbayev.onlinestore.model.entity.Users;
import kz.satbayev.onlinestore.model.repository.RoleRepository;
import kz.satbayev.onlinestore.model.repository.UserRepository;
import kz.satbayev.onlinestore.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users myUser = userRepository.findByEmail(username);
        if (myUser != null) {
            User secUser = new User(myUser.getEmail(), myUser.getPassword(), myUser.getRoles());
            return secUser;
        }
        throw new UsernameNotFoundException("User Not Found");
    }

    @Override
    public Users getUserByEmail(String email) {
        log.info("Searching user by email: {}", email);
        return userRepository.findByEmail(email);
    }

    @Override
    public Users createUser(String email,String password,String repassword,String fullName) {
        Users user = Users.builder().email(email).password(password).fullName(fullName).build();
        addUsers(email,password,repassword,fullName);
        Users checkUser = userRepository.findByEmail(user.getEmail());
        if (checkUser == null) {

            Roles role = roleRepository.findByRole("ROLE_USER");
            if (role != null) {
                ArrayList<Roles> roles = new ArrayList<>();
                roles.add(role);
                user.setRoles(roles);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                log.info("User registered successfully");
                return userRepository.save(user);
            }
        }
        log.info("User failed to register");
        return null;
    }

    public String addUsers(String email, String password, String repassword, String fullName) {
        log.info("Adding new user with email: {}", email);
        if (password.equals(repassword)) {
            Users newUser = new Users();
            newUser.setFullName(fullName);
            newUser.setPassword(password);
            newUser.setEmail(email);
            if (!fullName.isEmpty() && !password.isEmpty() && !email.isEmpty()) {
                log.info("User added successfully");
                return "redirect:/register?success";
            }
        }
         log.info("User addition failed");
        return "redirect:/register?error";
    }

    @Override
    public Users saveUser(Users user) {
        log.info("Saving user: {}", user);
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public Users getUser(Long id) {
        log.info("Fetching user by ID: {}", id);
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid element id: " + id));
    }

    public Users getUserData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User secUser = (User) authentication.getPrincipal();
            Users myUser = getUserByEmail(secUser.getUsername());
            return myUser;
        }
        return null;
    }
}
