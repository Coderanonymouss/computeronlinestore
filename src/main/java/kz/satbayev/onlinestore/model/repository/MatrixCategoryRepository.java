package kz.satbayev.onlinestore.model.repository;


import kz.satbayev.onlinestore.model.entity.MatrixCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatrixCategoryRepository  extends JpaRepository<MatrixCategories,Long> {
}
