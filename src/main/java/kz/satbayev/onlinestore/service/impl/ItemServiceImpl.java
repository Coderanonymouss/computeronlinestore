package kz.satbayev.onlinestore.service.impl;

import kz.satbayev.onlinestore.model.entity.ShopItems;
import kz.satbayev.onlinestore.model.repository.ShopItemsRepository;
import kz.satbayev.onlinestore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ShopItemsRepository shopItemRepository;

    @Override
    @Transactional
    public ShopItems addItems(ShopItems item) {

        return shopItemRepository.save(item);
    }

    @Autowired
    public ItemServiceImpl(ShopItemsRepository shopItemRepository) {
        this.shopItemRepository = shopItemRepository;

    }

    @Override
    public List<ShopItems> getAllItems() {
        return shopItemRepository.findAll();
    }

    @Override
    public ShopItems getItem(Long id) {

        return shopItemRepository.findByIdAndAmountGreaterThan(id,0L);
    }

    @Override
    @Transactional
    public ShopItems saveItem(ShopItems item) {

        return shopItemRepository.save(item);
    }

    @Override
    @Transactional
    public void deleteItem(ShopItems item) {
        shopItemRepository.delete(item);
    }
}
