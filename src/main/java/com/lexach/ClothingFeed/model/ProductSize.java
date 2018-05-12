package com.lexach.ClothingFeed.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ProductSize")
public class ProductSize implements Serializable {

    @Id
    private Long idProduct;

    @Id
    private Long idSize;

}
