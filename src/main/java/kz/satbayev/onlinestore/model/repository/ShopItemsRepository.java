package kz.satbayev.onlinestore.model.repository;

import kz.satbayev.onlinestore.model.entity.ShopItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopItemsRepository extends JpaRepository<ShopItems,Long> {
   List<ShopItems> findAllByAmountGreaterThanOrderByPriceDesc(Long amount);

   ShopItems findByIdAndAmountGreaterThan(Long id, Long amount);

   List<ShopItems> findAllByNameIsContainingIgnoreCase(String name);
}
