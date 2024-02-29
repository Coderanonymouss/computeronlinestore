package kz.satbayev.onlinestore.auth.models.dto;

import kz.satbayev.onlinestore.auth.models.entity.Role;
import lombok.Data;

import java.util.Set;


@Data
public class AuthenticationResponse {

    String username;
    Set<Role> authorities;
    String jwtToken;

    public AuthenticationResponse(String username, Set<Role> authorities, String token) {
        this.username = username;
        this.authorities = authorities;
        this.jwtToken = token;
    }
    public AuthenticationResponse(String username, Set<Role> authorities) {
        this.username = username;
        this.authorities = authorities;
    }
}
