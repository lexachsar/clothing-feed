package com.lexach.ClothingFeed.service.impl;

import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.repository.ProductRepository;
import com.lexach.ClothingFeed.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> findHottestProducts() {
        return productRepository.getFiftyBestElements();
    }
}
