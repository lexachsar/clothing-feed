package com.lexach.ClothingFeed.service;

import com.lexach.ClothingFeed.model.Product;
import org.springframework.ui.Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product save(Product product);

    public Optional<Product> findById(Long productId);

    public Iterable<Product> findHottestProducts();

    /**
     * Searches products.
     * @param searchTerm term to filter products by.
     * @return collection of products.
     */
    public LinkedList<Product> search(String searchTerm);

    public Product findByName(String searchTerm);

    public List<Product> findProductsAndAddToModel(Model model, String searchTerm);
}