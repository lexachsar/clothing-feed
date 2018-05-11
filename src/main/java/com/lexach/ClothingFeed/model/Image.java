package com.lexach.ClothingFeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

// Все модели должны быть аннотированы данной аннотацией.
@Entity
// Аннотация описывает детали таблички, к которой данная модель прилепится.
@Table(name = "Image")
// EntityListener для инжекта значения в поля под аннотацией @CreatedDate.
@EntityListeners(AuditingEntityListener.class)

// Это Jackson аннотация. Spring Boot использует Jackson для сериализации и десериализации Java объектов в и из JSON-а.
// Эта аннотация используется т.к. мы не хотим, чтобы клиенты rest api парились с предоставлением значиний createdAt и updatedAt.
// Если они предоставляют данные значения, мы просто их игнорим. Тем не менее, мы включаем эти значения в JSON response.
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String imageUrl;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    // TODO добавить аннотации для updatedAt
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
