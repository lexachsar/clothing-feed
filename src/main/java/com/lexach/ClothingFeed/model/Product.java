package com.lexach.ClothingFeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Product")

// EntityListener для инжекта значения в поля под аннотацией @CreatedDate.
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idRetailer", nullable = false)
    private Retailer retailer;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "idCategory", nullable = false)
    private ProductCategory category;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "oldPrice")
    private Double oldPrice;

    @Column(name = "priceCurrency", nullable = false)
    private String priceCurrency;

    @Column(name = "brandName", nullable = false)
    private String brandName;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updaedAt;

    @ManyToOne
    @JoinColumn(name = "idGeder")
    private Gender gender;

    // TODO Move to images entity
    @NotBlank
    @Column(nullable = false)
    private String mainImageLink;

    @ManyToOne
    @JoinColumn(name = "manufacturedCountryId")
    private Country manufacturedCountry;

    // One to many relations.
    @OneToMany(mappedBy = "product")
    private Set<ProductColour> productColours;

    @OneToMany(mappedBy = "product")
    private Set<ProductImage> productImages;

    @OneToMany()
    private Set<UserBookmark> userBookmarks;

    @OneToMany()
    private Set<ProductSize> productSize;

    public Product() {
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdaedAt() {
        return updaedAt;
    }

    public void setUpdaedAt(Date updaedAt) {
        this.updaedAt = updaedAt;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Country getManufacturedCountry() {
        return manufacturedCountry;
    }

    public void setManufacturedCountry(Country manufacturedCountry) {
        this.manufacturedCountry = manufacturedCountry;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getMainImageLink() {
        return mainImageLink;
    }

    public void setMainImageLink(String mainImageLink) {
        this.mainImageLink = mainImageLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
