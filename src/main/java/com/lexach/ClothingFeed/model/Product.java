package com.lexach.ClothingFeed.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Long idRetailer;

    @NotBlank
    private String name;

    @NotBlank
    private Long idCategory;

    @NotBlank
    private Integer price;

    @NotBlank
    private String brandName;

    @NotBlank
    private String url;

}
