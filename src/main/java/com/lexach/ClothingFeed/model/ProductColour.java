package com.lexach.ClothingFeed.model;

import javax.persistence.*;

@Entity
@Table(name = "ProductColour")
public class ProductColour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    

}
