package com.lexach.ClothingFeed.controller;

import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.model.ProductCategory;
import com.lexach.ClothingFeed.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;


@Controller
public class CategoryController {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @GetMapping("/category")
    public String category(Model model, @RequestParam Long categoryId, @RequestParam Integer page) {
        model.addAttribute("categories", productCategoryRepository.findAll());
        model.addAttribute("page", page);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("prevPage", page - 1);


        page--;

        Optional<ProductCategory> categoryOptional = productCategoryRepository.findById(categoryId);

        if(page < 0) {
            // TODO throw exception
        }

        if(page > 0) {
            model.addAttribute("isPrevPageExists", true);
        }

        if (categoryOptional.isPresent()){
            ProductCategory category = categoryOptional.get();
            model.addAttribute("currentCategory", category);

            ArrayList<Product> products = new ArrayList<Product>(category.getProducts());

            products.subList(80 * page, 80 + 80 * page);

            model.addAttribute("products1col", products.subList(0, 20));
            model.addAttribute("products2col", products.subList(20, 40));
            model.addAttribute("products3col", products.subList(40, 60));
            model.addAttribute("products4col", products.subList(60, 80));

        }

        return"/category/list";
    }

}
