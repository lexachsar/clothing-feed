package com.lexach.ClothingFeed.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ProductColour")
public class ProductColour implements Serializable {

    @Id
    private Long idProduct;

    @Id
    private Long idColour;

}
