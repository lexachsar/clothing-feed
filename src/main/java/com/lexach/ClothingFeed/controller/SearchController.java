package com.lexach.ClothingFeed.controller;

import com.lexach.ClothingFeed.controller.form.SearchFilterForm;
import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.model.SearchFilter;
import com.lexach.ClothingFeed.service.ProductCategoryService;
import com.lexach.ClothingFeed.service.ProductService;
import com.lexach.ClothingFeed.service.SearchFilterService;
import com.lexach.ClothingFeed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private SearchFilterService searchFilterService;

    @GetMapping("/all")
    public String searchAll(Model model, @RequestParam String searchTerm) {

        model.addAttribute("searchTerm", searchTerm);
        productCategoryService.addCategoriesToModel(model);

        productService.findProductsAndAddToModel(model, searchTerm);

        userService.findUsersAndAddToModel(model, searchTerm);

        productCategoryService.findCategoriesAndAddToModel(model, searchTerm);

        return "/search/all";

    }

    @GetMapping("/products")
    public String searchProducts(Model model, @RequestParam String searchTerm, @RequestParam Integer page) {

        model.addAttribute("searchTerm", searchTerm);
        productCategoryService.addCategoriesToModel(model);

        model.addAttribute("page", page);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("prevPage", page - 1);


        page--;

        if (page < 0) {
            // TODO throw exception
        }

        if (page > 0) {
            model.addAttribute("isPrevPageExists", true);
        }

        LinkedList<Product> products = productService.search(searchTerm);

        List<Product> productsPage = productService.getPage(products, page, 40);

        productService.createColumnsAndAddToModel(model, productsPage);

        return "/search/products";

    }

    @GetMapping("/filter")
    public String filter(Model model) {
        model.addAttribute("searchFilterForm", new SearchFilterForm());
        return ("/search/filter");
    }

    @PostMapping("/filter")
    public String filter(@ModelAttribute("searchFilterForm") SearchFilterForm searchFilterForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "search/filter";
        }

        SearchFilter searchFilter = searchFilterService.createSearchFilterFromForm(searchFilterForm);

        searchFilterService.save(searchFilter);

        return "redirect:/profile";
    }
}
