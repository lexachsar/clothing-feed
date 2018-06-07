package com.lexach.ClothingFeed.service.impl;

import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.repository.ProductRepository;
import com.lexach.ClothingFeed.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Iterable<Product> findHottestProducts() {
        return productRepository.getFiftyBestElements();
    }

    @Override
    public LinkedList<Product> search(String searchTerm) {
        Iterable<Product> allProducts = productRepository.findAll();

        LinkedList<Product> result = new LinkedList<>();

        for (Product product : allProducts) {

            if (product.getName().equals(searchTerm) ||
                    product.getBrandName().equals(searchTerm) ||
                    product.getRetailer().getName().equals(searchTerm) ||
                    product.getCategory().getName().equals(searchTerm) ||
                    product.getUrl().equals(searchTerm) ||
                    product.getGender().equals(searchTerm)) {
                result.add(product);
            }

        }

        return result;

    }

    @Override
    public Product findByName(String searchTerm) {
        return productRepository.findByName(searchTerm);
    }

    @Override
    public List<Product> findProductsAndAddToModel(Model model, String searchTerm) {
        LinkedList<Product> products = this.search(searchTerm);

        if(products.size() > 0) {

            List<Product> resultProducts;

            if(products.size() < 4) {
                resultProducts = products;
            } else {
                resultProducts = products.subList(0, 4);
            }

            model.addAttribute("products", resultProducts);

            return resultProducts;
        } else {
            return null;
        }
    }


}
