package com.lexach.clothing.feed.service;

import com.lexach.clothing.feed.model.ProductCategory;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {

    void addCategoriesToModel(Model model);

    Optional<ProductCategory> findById(Long categoryId);

    public List<ProductCategory> findCategoriesAndAddToModel(Model model, String searchTerm);

}
