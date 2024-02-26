package kz.satbayev.onlinestore.model.repository;

import kz.satbayev.onlinestore.model.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Categories, Long> {
    List<Categories> findAllByNameIsContainingIgnoreCase(String name);
}
