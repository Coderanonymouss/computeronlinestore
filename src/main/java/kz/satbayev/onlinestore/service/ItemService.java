package kz.satbayev.onlinestore.service;

import kz.satbayev.onlinestore.model.entity.ShopItems;

import java.util.List;

public interface ItemService {

    ShopItems addItems(ShopItems item);

    List<ShopItems> getAllItems();

    ShopItems getItem(Long id);

    ShopItems saveItem(ShopItems item);

    void deleteItem(ShopItems item);

    List<ShopItems> getSearchItem(String name);

}
