package com.lexach.ClothingFeed.controller;

import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.model.ProductCategory;
import com.lexach.ClothingFeed.repository.ProductCategoryRepository;
import com.lexach.ClothingFeed.service.ProductService;
import com.lexach.ClothingFeed.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
