package kz.satbayev.onlinestore.model.repository;


import kz.satbayev.onlinestore.model.entity.RAMCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RAMCategoryRepository extends JpaRepository<RAMCategories,Long> {
}
