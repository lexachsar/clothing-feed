package com.lexach.ClothingFeed.service;

import com.lexach.ClothingFeed.model.Product;

import java.util.LinkedList;
import java.util.Optional;

public interface ProductService {

    public Optional<Product> findById(Long productId);

    public Iterable<Product> findHottestProducts();

}
