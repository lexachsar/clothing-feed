package com.lexach.clothing.feed.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

// Все модели должны быть аннотированы данной аннотацией.
@Entity
// Аннотация описывает детали таблички, к которой данная модель прилепится.
@Table(name = "UserGroup")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, updatable = false)
    private String name;

    public UserGroup() {
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
}