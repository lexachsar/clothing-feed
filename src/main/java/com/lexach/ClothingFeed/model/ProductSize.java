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
}
