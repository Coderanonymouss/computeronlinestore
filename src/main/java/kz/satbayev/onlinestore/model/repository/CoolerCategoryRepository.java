package kz.satbayev.onlinestore.model.repository;


import kz.satbayev.onlinestore.model.entity.CoolerCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoolerCategoryRepository extends JpaRepository<CoolerCategories,Long> {
}
