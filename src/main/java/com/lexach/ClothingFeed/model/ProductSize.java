package com.lexach.ClothingFeed.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ProductSize")
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idProduct", nullable = false)
    private Product product;

    @Column(name = "size", nullable = false)
    private String size;

    @ManyToOne
    @JoinColumn(name = "sizeCountryId", nullable = false)
    private Country sizeCountry;

    public ProductSize() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Country getSizeCountry() {
        return sizeCountry;
    }

    public void setSizeCountry(Country sizeCountry) {
        this.sizeCountry = sizeCountry;
    }
}
