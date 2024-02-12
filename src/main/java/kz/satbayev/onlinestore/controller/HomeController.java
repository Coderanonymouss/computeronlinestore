package kz.satbayev.onlinestore.controller;

import kz.satbayev.onlinestore.model.entity.ShopItems;
import kz.satbayev.onlinestore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HomeController {

    private final ItemService itemService;

    @Autowired
    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/")
    public String index(Model model) {
        List<ShopItems> items = itemService.getAllItems();
        model.addAttribute("tovary", items);
        return "index";
    }

    @GetMapping("/era")
    public String checkEra() {
        return "about";
    }

}
