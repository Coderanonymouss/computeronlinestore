package kz.satbayev.onlinestore.model.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VideoCardCategoriesDto {

    private String name;

    private Long price;

    @Override
    public String toString() {
        return "VideoCardCategoriesDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
