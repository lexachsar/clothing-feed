package com.lexach.clothing.feed.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Retailer")
public class Retailer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "rootUrl", nullable = false, unique = true)
    private String rootUrl;

    @Column(name = "parserClassName", nullable = false, unique = true)
    private String parserClassName;

    @OneToMany(mappedBy = "retailer")
    private Set<Product> products;

    public Retailer() {
    }

    public Retailer(String name, String rootUrl, String parserClassName) {
        this.name = name;
        this.rootUrl = rootUrl;
        this.parserClassName = parserClassName;
        this.products = new HashSet();
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

    public String getRootUrl() {
        return rootUrl;
    }

    public void setRootUrl(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    public String getParserClassName() {
        return parserClassName;
    }

    public void setParserClassName(String parserClassName) {
        this.parserClassName = parserClassName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
