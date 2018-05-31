package com.lexach.ClothingFeed.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

// Все модели должны быть аннотированы данной аннотацией.
@Entity
// Аннотация описывает детали таблички, к которой данная модель прилепится.
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "manufacturedCountry")
    private Set<Product> products;

    @OneToMany(mappedBy = "sizeCountry")
    private Set<ProductSize> prouctSizes;

    public Country() {
    }

    public Country(String name) {
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

    public Set<ProductSize> getProuctSizes() {
        return prouctSizes;
    }

    public void setProuctSizes(Set<ProductSize> prouctSizes) {
        this.prouctSizes = prouctSizes;
    }
}
