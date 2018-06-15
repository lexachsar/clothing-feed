package com.lexach.clothing.feed.repository;

import com.lexach.clothing.feed.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {

    List<ProductCategory> findByName(String name);

}