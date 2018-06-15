package com.lexach.clothing.feed.service.impl;

import com.lexach.clothing.feed.model.ProductCategory;
import com.lexach.clothing.feed.repository.ProductCategoryRepository;
import com.lexach.clothing.feed.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<ProductCategory> findCategoriesAndAddToModel(Model model, String searchTerm) {
        List<ProductCategory> productCategories = productCategoryRepository.findByName(searchTerm);

        if(productCategories.size() > 0) {

            List<ProductCategory> resultProductCategories;

            if(productCategories.size() < 4) {
                resultProductCategories = productCategories;
            } else {
                resultProductCategories = productCategories.subList(0, 4);
            }

            model.addAttribute("foundCategories", resultProductCategories);

            return resultProductCategories;
        } else {
            return null;
        }
    }

}
