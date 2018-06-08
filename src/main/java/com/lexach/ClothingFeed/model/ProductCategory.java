package com.lexach.ClothingFeed.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ProductCategory")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    @OneToMany(mappedBy = "category")
    private Set<SearchFilter> searchFilters;

    public ProductCategory() {
    }

    public ProductCategory(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<SearchFilter> getSearchFilters() {
        return searchFilters;
    }

    public void setSearchFilters(Set<SearchFilter> searchFilters) {
        this.searchFilters = searchFilters;
    }
}
