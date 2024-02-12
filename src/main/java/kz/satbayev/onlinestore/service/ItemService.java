package kz.satbayev.onlinestore.service;

import kz.satbayev.onlinestore.model.entity.ShopItems;
import kz.satbayev.onlinestore.model.entity.ShopItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ShopItemsRepository shopItemsRepository;

    @Autowired
    public ItemService(ShopItemsRepository shopItemsRepository) {
        this.shopItemsRepository = shopItemsRepository;
    }

    public List<ShopItems> getAllItems() {
        return shopItemsRepository.findAll();
    }
}
