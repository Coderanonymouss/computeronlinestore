package kz.satbayev.onlinestore.service;

import kz.satbayev.onlinestore.model.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    Users getUserByEmail(String email);
    Users createUser(String email,String password,String repassword,String fullName);
    Users saveUser(Users user);
    List<Users> getAllUsers();

Users getUser(Long id);
    Users getUserData();
}
