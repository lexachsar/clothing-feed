package com.lexach.clothing.feed.service;

import com.lexach.clothing.feed.model.Product;
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

    /**
     * Creates columns from @param products and adds them to @param model.
     * @return Number of products, added to model.
     */
    public Integer createColumnsAndAddToModel(Model model, List<Product> products);

    public List<Product> getPage(List<Product> products, Integer page, Integer productsPerPage);

}