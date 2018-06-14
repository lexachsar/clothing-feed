package com.lexach.ClothingFeed.service.impl;

import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.repository.ProductRepository;
import com.lexach.ClothingFeed.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
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
        return productRepository.getFortyBestElements();
    }

    @Override
    public LinkedList<Product> search(String searchTerm) {
        Iterable<Product> allProducts = productRepository.findAll();

        LinkedList<Product> result = new LinkedList<>();

        for (Product product : allProducts) {

            if (product.getName().contains(searchTerm) ||
                    product.getBrandName().contains(searchTerm) ||
                    product.getRetailer().getName().contains(searchTerm) ||
                    product.getCategory().getName().contains(searchTerm) ||
                    product.getUrl().contains(searchTerm) ||
                    product.getGender().getName().contains(searchTerm)) {
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

        if (products.size() > 0) {

            List<Product> resultProducts;

            if (products.size() < 4) {
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

    @Override
    public Integer createColumnsAndAddToModel(Model model, List<Product> products) {

        Integer columnSize;

        if (Objects.isNull(products) || products.isEmpty()) {
            model.addAttribute("errorProductsAreEmpty", true);
            columnSize = 0;
        } else {
            columnSize = products.size() / 4;
            model.addAttribute("products1col", products.subList(0, columnSize));
            model.addAttribute("products2col", products.subList(columnSize, columnSize * 2));
            model.addAttribute("products3col", products.subList(columnSize * 2, columnSize * 3));
            model.addAttribute("products4col", products.subList(columnSize * 3, products.size()));
            model.addAttribute("numberOfProducts", products.size());
        }


        return columnSize * 4;
    }

    @Override
    public List<Product> getPage(List<Product> products, Integer page, Integer productsPerPage) {

        List<Product> productsPage;

        Integer leftBound = productsPerPage * page;
        Integer rightBound = productsPerPage + productsPerPage * page;

        if (products.size() < rightBound && products.size() > leftBound) {
            productsPage = products.subList(leftBound, products.size());
        } else if (products.size() != 0 && products.size() > leftBound) {
            productsPage = products.subList(leftBound, rightBound);
        } else {
            productsPage = null;
        }

        return productsPage;
    }


}
