package kz.satbayev.onlinestore.controller;

import kz.satbayev.onlinestore.model.entity.Company;
import kz.satbayev.onlinestore.model.entity.ShopItems;
import kz.satbayev.onlinestore.service.AllCategoriesService;
import kz.satbayev.onlinestore.service.CompanyService;
import kz.satbayev.onlinestore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class HomeController {

    private final AllCategoriesService allCategoriesService;
    private final CompanyService companyService;
    private final ItemService itemService;

    @Autowired
    public HomeController(AllCategoriesService allCategoriesService, CompanyService companyService, ItemService itemService) {
        this.allCategoriesService = allCategoriesService;
        this.companyService = companyService;
        this.itemService = itemService;
    }


    @GetMapping("/")
    public String index(Model model) {
        List<ShopItems> items = itemService.getAllItems();
        model.addAttribute("tovary", items);
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/details/{id}")
    public String details(Model model, @PathVariable(name = "id") Long id) {
        ShopItems item = itemService.getItem(id);
        List<Company> companies = companyService.getAllCompany();
        model.addAttribute("companies", companies);
        model.addAttribute("item", item);
        allCategoriesService.getAll(model);

        return "details";
    }

}
