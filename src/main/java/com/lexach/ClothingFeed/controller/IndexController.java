package com.lexach.ClothingFeed.controller;

import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.service.ProductCategoryService;
import com.lexach.ClothingFeed.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class IndexController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/")
    public String index(Model model) {

        // Adding categories to model, so they are showed on sidebar.
        productCategoryService.addCategoriesToModel(model);

        // TODO try to change this part.
        ArrayList<Product> products = (ArrayList<Product>) productService.findHottestProducts();

        if(products.isEmpty()) {
            model.addAttribute("errorProductsAreEmpty", true);
        } else {
            model.addAttribute("products1col", products.subList(0, 10));
            model.addAttribute("products2col", products.subList(10, 20));
            model.addAttribute("products3col", products.subList(20, 30));
            model.addAttribute("products4col", products.subList(30, 40));
        }

        return "/index";
    }
}