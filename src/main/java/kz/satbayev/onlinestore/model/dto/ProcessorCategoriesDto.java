package kz.satbayev.onlinestore.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProcessorCategoriesDto {

    private String name;

    private Long price;

    @Override
    public String toString() {
        return "ProcessorCategoriesDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
