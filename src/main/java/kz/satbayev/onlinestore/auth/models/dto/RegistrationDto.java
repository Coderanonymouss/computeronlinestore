package kz.satbayev.onlinestore.auth.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {

    private String username;
    private String password;

    @Override
    public String toString() {
        return "Registration info:" +
                "username='" + username + '\'' +
                ", password='" + password;
    }
}
