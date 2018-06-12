package com.lexach.ClothingFeed.model;

import javax.persistence.*;

@Entity
@Table(name = "ColourComposite")
public class ColourComposite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idProductColour", nullable = false)
    private ProductColour productColour;

    @ManyToOne
    @JoinColumn(name = "idColour", nullable = false)
    private Colour colour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductColour getProductColour() {
        return productColour;
    }

    public void setProductColour(ProductColour productColour) {
        this.productColour = productColour;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }
}
