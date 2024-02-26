package kz.satbayev.onlinestore.controller;

import kz.satbayev.onlinestore.model.entity.Company;
import kz.satbayev.onlinestore.model.entity.ShopItems;
import kz.satbayev.onlinestore.service.impl.AllCategoriesServiceImpl;
import kz.satbayev.onlinestore.service.impl.CompanyServiceImpl;
import kz.satbayev.onlinestore.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class HomeController {

    private final AllCategoriesServiceImpl allCategoriesServiceImpl;
    private final CompanyServiceImpl companyServiceImpl;
    private final ItemServiceImpl itemServiceImpl;

    @Autowired
    public HomeController(AllCategoriesServiceImpl allCategoriesServiceImpl, CompanyServiceImpl companyServiceImpl, ItemServiceImpl itemServiceImpl) {
        this.allCategoriesServiceImpl = allCategoriesServiceImpl;
        this.companyServiceImpl = companyServiceImpl;
        this.itemServiceImpl = itemServiceImpl;
    }


    @GetMapping("/")
    public String index(Model model) {
        List<ShopItems> items = itemServiceImpl.getAllItems();
        model.addAttribute("tovary", items);
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/details/{id}")
    public String details(Model model, @PathVariable(name = "id") Long id) {
        ShopItems item = itemServiceImpl.getItem(id);
        List<Company> companies = companyServiceImpl.getAllCompany();
        model.addAttribute("companies", companies);
        model.addAttribute("item", item);
        allCategoriesServiceImpl.getAll(model);

        return "details";
    }

}
