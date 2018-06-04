package com.lexach.ClothingFeed.model;

import com.lexach.ClothingFeed.model.Colour;
import com.lexach.ClothingFeed.model.Product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ProductColour")
public class ProductColour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idProduct", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "idColour", nullable = false)
    private Colour colour;



}
