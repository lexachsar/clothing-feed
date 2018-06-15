package com.lexach.clothing.feed.controller;

import com.lexach.clothing.feed.model.Product;
import com.lexach.clothing.feed.model.ProductCategory;
import com.lexach.clothing.feed.repository.ProductCategoryRepository;
import com.lexach.clothing.feed.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class IndexController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @GetMapping("/")
    public String index(Model model) {

        ArrayList<ProductCategory> allProductCategories = (ArrayList<ProductCategory>) productCategoryRepository.findAll();

        if(allProductCategories.isEmpty()) {
            model.addAttribute("errorCategoriesAreEmpty", true);
        } else {
            model.addAttribute("categories", allProductCategories);
        }

        // TODO try to change this part.
        ArrayList<Product> products = (ArrayList<Product>) productService.findHottestProducts();

        productService.createColumnsAndAddToModel(model, products);

        return "/index";
    }
}
