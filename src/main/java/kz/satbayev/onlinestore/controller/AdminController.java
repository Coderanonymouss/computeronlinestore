package kz.satbayev.onlinestore.controller;

import kz.satbayev.onlinestore.model.entity.*;
import kz.satbayev.onlinestore.service.AllCategoriesService;
import kz.satbayev.onlinestore.service.CompanyService;
import kz.satbayev.onlinestore.service.ItemService;
import kz.satbayev.onlinestore.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController()
@RequestMapping("/admin")
public class AdminController {
    private final CompanyService companyService;
    private final AllCategoriesService allCategoriesService;
    private final ItemService itemService;
    private final UserService userService;

    public AdminController(CompanyService companyService, AllCategoriesService allCategoriesService, ItemService itemService, UserService userService) {
        this.companyService = companyService;
        this.allCategoriesService = allCategoriesService;
        this.itemService = itemService;
        this.userService = userService;
    }

}
