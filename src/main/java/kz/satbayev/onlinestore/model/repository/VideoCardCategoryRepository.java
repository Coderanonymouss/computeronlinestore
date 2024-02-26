package kz.satbayev.onlinestore.model.repository;


import kz.satbayev.onlinestore.model.entity.VideoCardCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoCardCategoryRepository extends JpaRepository<VideoCardCategories,Long> {
}
