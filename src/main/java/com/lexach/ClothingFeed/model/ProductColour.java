package com.lexach.ClothingFeed.model;

import javax.persistence.*;
import java.util.Set;

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

    // One to many relations.
    // Colour composite collection.
    @OneToMany(mappedBy = "productColour")
    private Set<ColourComposite> coloursComposite;

    public ProductColour(Product product, Colour colour) {
        this.product = product;
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

    public Set<ColourComposite> getColoursComposite() {
        return coloursComposite;
    }

    public void setColoursComposite(Set<ColourComposite> coloursComposite) {
        this.coloursComposite = coloursComposite;
    }
}
