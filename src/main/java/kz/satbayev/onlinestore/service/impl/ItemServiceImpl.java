package kz.satbayev.onlinestore.service.impl;

import groovyjarjarantlr4.v4.gui.TreeViewer;
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
    private final ShopItemsRepository shopItemsRepository;

    @Autowired
    public ItemServiceImpl(ShopItemsRepository shopItemRepository, ShopItemsRepository shopItemsRepository) {
        this.shopItemRepository = shopItemRepository;
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
