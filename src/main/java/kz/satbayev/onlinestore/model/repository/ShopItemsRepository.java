package kz.satbayev.onlinestore.model.repository;

import kz.satbayev.onlinestore.model.entity.ShopItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ShopItemsRepository extends JpaRepository<ShopItems,Long> {
   List<ShopItems> findAllByAmountGreaterThanOrderByPriceDesc(Long amount);

   ShopItems findByIdAndAmountGreaterThan(Long id, Long amount);

   List<ShopItems> findAllByNameIsContainingIgnoreCase(String name);
}
