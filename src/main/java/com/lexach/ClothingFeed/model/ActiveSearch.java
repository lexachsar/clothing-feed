package com.lexach.ClothingFeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

// Все модели должны быть аннотированы данной аннотацией.
@Entity
// Аннотация описывает детали таблички, к которой данная модель прилепится.
@Table(name = "ActiveSearch")
// EntityListener для инжекта значения в поля под аннотацией @CreatedDate.
@EntityListeners(AuditingEntityListener.class)

// Это Jackson аннотация. Spring Boot использует Jackson для сериализации и десериализации Java объектов в и из JSON-а.
// Эта аннотация используется т.к. мы не хотим, чтобы клиенты rest api парились с предоставлением значиний createdAt и updatedAt.
// Если они предоставляют данные значения, мы просто их игнорим. Тем не менее, мы включаем эти значения в JSON response.
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class ActiveSearch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @NotBlank
    private Long idUser;

    @NotBlank
    private Long idCategory;

    @NotBlank
    private Long idColour;

    @NotBlank
    private Long idCategorySize;

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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Long getIdColour() {
        return idColour;
    }

    public void setIdColour(Long idColour) {
        this.idColour = idColour;
    }

    public Long getIdCategorySize() {
        return idCategorySize;
    }

    public void setIdCategorySize(Long idCategorySize) {
        this.idCategorySize = idCategorySize;
    }
}
