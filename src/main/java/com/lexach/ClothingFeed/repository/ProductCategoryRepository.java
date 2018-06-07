package com.lexach.ClothingFeed.repository;

import com.lexach.ClothingFeed.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {

    List<ProductCategory> findByName(String name);

}