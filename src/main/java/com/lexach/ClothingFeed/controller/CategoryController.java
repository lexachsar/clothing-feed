package com.lexach.ClothingFeed.controller;

import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.model.ProductCategory;
import com.lexach.ClothingFeed.repository.ProductCategoryRepository;
import com.lexach.ClothingFeed.service.ProductCategoryService;
import com.lexach.ClothingFeed.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Controller
public class CategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/category")
    public String category(Model model, @RequestParam Long categoryId, @RequestParam Integer page) {

        // Adding categories to model, so they are showed on sidebar.
        productCategoryService.addCategoriesToModel(model);

        model.addAttribute("page", page);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("prevPage", page - 1);


        page--;

        Optional<ProductCategory> categoryOptional = productCategoryService.findById(categoryId);

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

            List<Product> productsPage = productService.getPage(products, page, 80);

            productService.createColumnsAndAddToModel(model, productsPage);

        }

        return"/category/list";
    }

}
