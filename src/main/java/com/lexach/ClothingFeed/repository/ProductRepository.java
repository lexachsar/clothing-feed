package com.lexach.ClothingFeed.repository;

import com.lexach.ClothingFeed.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * FROM product ORDER BY price LIMIT 40", nativeQuery = true)
    Iterable<Product> getFortyBestElements();

    Product findByName(String name);

    Iterable<Product> findByNameOrBrandNameOrUrl(String name, String brandName, String url);

}
