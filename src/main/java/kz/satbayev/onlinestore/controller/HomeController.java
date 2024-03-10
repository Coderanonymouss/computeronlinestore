package kz.satbayev.onlinestore.controller;


import kz.satbayev.onlinestore.model.entity.*;
import kz.satbayev.onlinestore.service.AllCategoriesService;
import kz.satbayev.onlinestore.service.CompanyService;
import kz.satbayev.onlinestore.service.ItemService;
import kz.satbayev.onlinestore.service.UserService;
import kz.satbayev.onlinestore.service.impl.AllCategoriesServiceImpl;
import kz.satbayev.onlinestore.service.impl.CompanyServiceImpl;
import kz.satbayev.onlinestore.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@Controller
public class HomeController {

    private final UserService userService;
    private final AllCategoriesServiceImpl allCategoriesServiceImpl;
    private final CompanyServiceImpl companyServiceImpl;
    private final ItemServiceImpl itemServiceImpl;
    private final CompanyService companyService;
    private final AllCategoriesService allCategoriesService;
    private final ItemService itemService;

    @Autowired
    public HomeController(UserService userService, AllCategoriesServiceImpl allCategoriesServiceImpl, CompanyServiceImpl companyServiceImpl, ItemServiceImpl itemServiceImpl, CompanyService companyService, AllCategoriesService allCategoriesService, ItemService itemService) {
        this.userService = userService;
        this.allCategoriesServiceImpl = allCategoriesServiceImpl;
        this.companyServiceImpl = companyServiceImpl;
        this.itemServiceImpl = itemServiceImpl;
        this.companyService = companyService;
        this.allCategoriesService = allCategoriesService;
        this.itemService = itemService;
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
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("currentUser", userService.getUserData());
        return "register";
    }

    @PostMapping(value = "/register")
    public Users toRegister(@RequestParam(name = "user_email") String email,
                            @RequestParam(name = "user_password") String password,
                            @RequestParam(name = "re_user_password") String repassword,
                            @RequestParam(name = "user_full_name") String fullName) {
        return userService.createUser(email,password,repassword,fullName);
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("currentUser", userService.getUserData());
        return "login";
    }

    @GetMapping("/add-item")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    public String addItem(Model model) {
        model.addAttribute("currentUser", userService.getUserData());

        List<Company> companies = companyService.getAllCompany();
        model.addAttribute("companies", companies);
        allCategoriesService.getAll(model);
        return "addItem";
    }

    @PostMapping("/add-item")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    public String addItem(@RequestParam(value = "item_name") String name,
                          @RequestParam(value = "item_company") Long company,
                          @RequestParam(value = "item_price") Long price,
                          @RequestParam(value = "item_amount") Long amount,
                          @RequestParam(value = "item_cooler") Long cooler,
                          @RequestParam(value = "item_matrix") Long matrix,
                          @RequestParam(value = "item_processor") Long processor,
                          @RequestParam(value = "item_ram") Long ram,
                          @RequestParam(value = "item_videoCard") Long videoCard) {

        Company companies = companyService.getCompany(company);
        CoolerCategories coolers = allCategoriesService.getCooler(cooler);
        MatrixCategories matrices = allCategoriesService.getMatrix(matrix);
        ProcessorCategories processors = allCategoriesService.getProcessor(processor);
        RAMCategories rams = allCategoriesService.getRAM(ram);
        VideoCardCategories videoCards = allCategoriesService.getVideoCard(videoCard);

        ShopItems item = ShopItems
                .builder()
                .name(name)
                .price(price)
                .amount(amount)
                .company(companies)
                .coolerCategories(coolers)
                .matrixCategories(matrices)
                .processorCategories(processors)
                .ramCategories(rams)
                .videoCardCategories(videoCards)
                .build();
        itemService.addItems(item);
        return "redirect:/";
    }

    @GetMapping("/editItem/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editItem(Model model, @PathVariable(name = "id") Long id) {
        ShopItems item = itemService.getItem(id);
        List<Company> companies = companyService.getAllCompany();
        model.addAttribute("item", item);
        model.addAttribute("companies", companies);
        allCategoriesService.getAll(model);
        return "editItem";
    }

    @GetMapping("/403")
    public String accesDenied(Model model) {
        model.addAttribute("currentUser", userService.getUserData());
        return "mistake";
    }

    @PostMapping("/saveItem")
    public String saveItem(@RequestParam(value = "id", defaultValue = "0") Long id,
                           @RequestParam(value = "item_name", defaultValue = "No Item") String name,
                           @RequestParam(value = "item_price", defaultValue = "0") Long price,
                           @RequestParam(value = "item_amount", defaultValue = "0") Long amount,
                           @RequestParam(value = "item_company") Long company,
                           @RequestParam(value = "item_cooler") Long cooler,
                           @RequestParam(value = "item_matrix") Long matrix,
                           @RequestParam(value = "item_processor") Long processor,
                           @RequestParam(value = "item_ram") Long ram,
                           @RequestParam(value = "item_videoCard") Long videoCard) {

        Company companies = companyService.getCompany(company);
        CoolerCategories coolers = allCategoriesService.getCooler(cooler);
        MatrixCategories matrices = allCategoriesService.getMatrix(matrix);
        ProcessorCategories processors = allCategoriesService.getProcessor(processor);
        RAMCategories rams = allCategoriesService.getRAM(ram);
        VideoCardCategories videoCards = allCategoriesService.getVideoCard(videoCard);
        ShopItems item = itemService.getItem(id);
        if (Objects.nonNull(item)) {
            ShopItems items = ShopItems
                    .builder()
                    .id(id)
                    .company(companies)
                    .coolerCategories(coolers)
                    .matrixCategories(matrices)
                    .processorCategories(processors)
                    .ramCategories(rams)
                    .videoCardCategories(videoCards)
                    .name(name)
                    .amount(amount)
                    .price(price)
                    .build();
            itemService.saveItem(items);
        }
        return "redirect:/";
    }

    @PostMapping("/deleteItem")
    public String deleteItem(@RequestParam(name = "id", defaultValue = "0") Long id) {
        ShopItems item = itemService.getItem(id);
        if (Objects.nonNull(item)) {
            itemService.deleteItem(item);
        }
        return "redirect:/";
    }

}
