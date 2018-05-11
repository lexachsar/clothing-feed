package com.lexach.ClothingFeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

// Все модели должны быть аннотированы данной аннотацией.
@Entity
// Аннотация описывает детали таблички, к которой данная модель прилепится.
@Table(name = "CategorySize")
public class CategorySize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Long idCategory;

    @NotBlank
    private Integer ruSize;

    @NotBlank
    private Integer ukSize;

    @NotBlank
    private Integer usSize;

    @NotBlank
    private Integer euSize;

    @NotBlank
    private Integer itSize;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Integer getRuSize() {
        return ruSize;
    }

    public void setRuSize(Integer ruSize) {
        this.ruSize = ruSize;
    }

    public Integer getUkSize() {
        return ukSize;
    }

    public void setUkSize(Integer ukSize) {
        this.ukSize = ukSize;
    }

    public Integer getUsSize() {
        return usSize;
    }

    public void setUsSize(Integer usSize) {
        this.usSize = usSize;
    }

    public Integer getEuSize() {
        return euSize;
    }

    public void setEuSize(Integer euSize) {
        this.euSize = euSize;
    }

    public Integer getItSize() {
        return itSize;
    }

    public void setItSize(Integer itSize) {
        this.itSize = itSize;
    }
}
