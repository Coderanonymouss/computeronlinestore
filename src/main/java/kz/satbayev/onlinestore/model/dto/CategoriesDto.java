package kz.satbayev.onlinestore.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesDto {

    private String name;

    private CompanyDto company;

    private CoolerCategoriesDto coolerCategories;

    private MatrixCategoriesDto matrixCategories;

    private ProcessorCategoriesDto processorCategories;

    private RAMCategoriesDto ramCategories;

    private VideoCardCategoriesDto videoCardCategories;

    private Long price;

    @Override
    public String toString() {
        return "CategoriesDto{" +
                "name='" + name + '\'' +
                ", company=" + company +
                ", coolerCategories=" + coolerCategories +
                ", matrixCategories=" + matrixCategories +
                ", processorCategories=" + processorCategories +
                ", ramCategories=" + ramCategories +
                ", videoCardCategories=" + videoCardCategories +
                ", price=" + price +
                '}';
    }
}
