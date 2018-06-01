package com.lexach.ClothingFeed.repository;

import com.lexach.ClothingFeed.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
}
