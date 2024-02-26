package kz.satbayev.onlinestore.service;

import kz.satbayev.onlinestore.model.entity.ShopItems;

import java.util.List;

public interface ItemService {

    List<ShopItems> getAllItems();

    ShopItems getItem(Long id);

}
