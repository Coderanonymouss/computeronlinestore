package kz.satbayev.onlinestore.model.repository;


import kz.satbayev.onlinestore.model.entity.ProcessorCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessorCategoryRepository extends JpaRepository<ProcessorCategories,Long> {
}
