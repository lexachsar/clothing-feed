package com.lexach.clothing.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UserBookmark", uniqueConstraints={
        @UniqueConstraint(columnNames = {"idProduct", "idUser"}) })
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class UserBookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idProduct", nullable = false, updatable = false)
    private Product product;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "createdAt", nullable = false, updatable = false)
    private Date createdAt;

    public UserBookmark(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public UserBookmark() {
    }

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
