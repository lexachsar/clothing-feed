package com.lexach.ClothingFeed.service;

import com.lexach.ClothingFeed.model.Product;

import java.util.LinkedList;

public interface ProductService {

    public Iterable<Product> findHottestProducts();

}
