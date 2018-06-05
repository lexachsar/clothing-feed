package com.lexach.ClothingFeed.service;

import com.lexach.ClothingFeed.model.ProductCategory;
import org.springframework.ui.Model;

import java.util.Optional;

public interface ProductCategoryService {

    void addCategoriesToModel(Model model);

    Optional<ProductCategory> findById(Long categoryId);

}