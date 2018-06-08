package com.lexach.ClothingFeed.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

// Все модели должны быть аннотированы данной аннотацией.
@Entity
// Аннотация описывает детали таблички, к которой данная модель прилепится.
@Table(name = "CategorySize")
public class CategorySize{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "idCategory", nullable = false)
    private Long idCategory;

    @Column(name = "ruSize", nullable = false)
    private Integer ruSize;

    @Column(name = "ukSize", nullable = false)
    private Integer ukSize;

    @Column(name = "usSize", nullable = false)
    private Integer usSize;

    @Column(name = "euSize", nullable = false)
    private Integer euSize;

    @Column(name = "itSize", nullable = false)
    private Integer itSize;

    @OneToMany(mappedBy = "categorySize")
    private Set<SearchFilter> searchFilters;

    public CategorySize() {
    }

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

    public Set<SearchFilter> getSearchFilters() {
        return searchFilters;
    }

    public void setSearchFilters(Set<SearchFilter> searchFilters) {
        this.searchFilters = searchFilters;
    }
}
