package kz.satbayev.onlinestore.service.impl;

import kz.satbayev.onlinestore.model.entity.ShopItems;
import kz.satbayev.onlinestore.model.repository.ShopItemsRepository;
import kz.satbayev.onlinestore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ShopItemsRepository shopItemsRepository;

    @Autowired
    public ItemServiceImpl(ShopItemsRepository shopItemsRepository) {
        this.shopItemsRepository = shopItemsRepository;
    }

    @Override
    public List<ShopItems> getAllItems() {
        return shopItemsRepository.findAll();
    }

    @Override
    public ShopItems getItem(Long id) {

        return shopItemsRepository.findByIdAndAmountGreaterThan(id,0L);
    }
}
