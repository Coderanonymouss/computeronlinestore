package kz.satbayev.onlinestore.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private String name;

    @Override
    public String toString() {
        return "CompanyDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
