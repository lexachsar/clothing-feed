package com.lexach.ClothingFeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

// Все модели должны быть аннотированы данной аннотацией.
@Entity
// Аннотация описывает детали таблички, к которой данная модель прилепится.
@Table(name = "SearchFilter")
// EntityListener для инжекта значения в поля под аннотацией @CreatedDate.
@EntityListeners(AuditingEntityListener.class)

// Это Jackson аннотация. Spring Boot использует Jackson для сериализации и десериализации Java объектов в и из JSON-а.
// Эта аннотация используется т.к. мы не хотим, чтобы клиенты rest api парились с предоставлением значиний createdAt и updatedAt.
// Если они предоставляют данные значения, мы просто их игнорим. Тем не менее, мы включаем эти значения в JSON response.
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class SearchFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private ProductCategory category;

    @ManyToOne
    @JoinColumn(name = "idColour")
    private Colour colour;

    @ManyToOne
    @JoinColumn(name = "idCategorySize")
    private CategorySize categorySize;

    @ManyToOne
    @JoinColumn(name = "idGender")
    private Gender gender;

    @Transient
    private List<Product> productList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public CategorySize getCategorySize() {
        return categorySize;
    }

    public void setCategorySize(CategorySize categorySize) {
        this.categorySize = categorySize;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {

        if (!Objects.isNull(productList)) {
            if (productList.size() < 4) {
                if (productList.size() > 0) {
                    this.productList = productList;
                }
            } else {
                this.productList = productList.subList(0, 4);
            }
        }
    }
}
