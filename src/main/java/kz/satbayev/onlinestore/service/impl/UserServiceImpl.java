package kz.satbayev.onlinestore.service.impl;

import kz.satbayev.onlinestore.model.entity.Roles;
import kz.satbayev.onlinestore.model.entity.Users;
import kz.satbayev.onlinestore.model.repository.RoleRepository;
import kz.satbayev.onlinestore.model.repository.UserRepository;
import kz.satbayev.onlinestore.service.UserService;
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
                return userRepository.save(user);
            }
        }
        return null;
    }

    public String addUsers(String email,String password,String repassword,String fullName){
        if (password.equals(repassword)) {
            Users newUser = new Users();
            newUser.setFullName(fullName);
            newUser.setPassword(password);
            newUser.setEmail(email);
            if (!fullName.isEmpty() && !password.isEmpty() && !email.isEmpty()) {
                return "redirect:/register?success";
            }
        }
        return "redirect:/register?error";
    }

    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid element id: " + id));
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
