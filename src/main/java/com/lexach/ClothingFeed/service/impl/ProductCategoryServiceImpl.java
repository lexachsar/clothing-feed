package com.lexach.ClothingFeed.service.impl;

import com.lexach.ClothingFeed.model.ProductCategory;
import com.lexach.ClothingFeed.repository.ProductCategoryRepository;
import com.lexach.ClothingFeed.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public void addCategoriesToModel(Model model) {

        ArrayList<ProductCategory> allProductCategories = (ArrayList<ProductCategory>) productCategoryRepository.findAll();

        if(allProductCategories.isEmpty()) {
            model.addAttribute("errorCategoriesAreEmpty", true);
        } else {
            model.addAttribute("categories", allProductCategories);
        }

    }

    @Override
    public Optional<ProductCategory> findById(Long categoryId) {
        return productCategoryRepository.findById(categoryId);
    }

}
