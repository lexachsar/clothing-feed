package com.lexach.ClothingFeed.repository;

import com.lexach.ClothingFeed.model.Gender;
import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.model.ProductCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // TODO Check this query.
    @Query(value = "SELECT * FROM product ORDER BY price, created_at LIMIT 40", nativeQuery = true)
    List<Product> getFortyBestElements();

    Product findByName(String name);

    Iterable<Product> findByNameOrBrandNameOrUrl(String name, String brandName, String url);

    List<Product> findDistinctByCategoryOrGenderOrderByCreatedAt(ProductCategory category, Gender gender);

    List<Product> findByCategoryOrderByCreatedAt(ProductCategory category);

    List<Product> findByGenderOrderByCreatedAt(Gender gender);
}
