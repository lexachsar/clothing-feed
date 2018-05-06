package com.lexach.ClothingFeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

// Все модели должны быть аннотированы данной аннотацией.
@Entity
// Аннотация описывает детали таблички, к которой данная модель прилепится.
@Table(name = "Users")
// EntityListener для инжекта значения в поля под аннотацией @CreatedDate.
@EntityListeners(AuditingEntityListener.class)

// TODO разобрать аннотацию
// This annotation is a Jackson annotation. Spring Boot uses Jackson for Serializing and Deserializing Java objects to and from JSON.
//
//This annotation is used because we don’t want the clients of the rest api to supply the createdAt and updatedAt values.
// If they supply these values then we’ll simply ignore them. However, we’ll include these values in the JSON response.
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nickname;

    @NotBlank
    private String passwordHashSum;

    @Column(nullable = false, updatable = false)
    // Конвертирует типы date и time в соответствующие типы БД.
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @NotBlank
    private Enum gender;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date registrationDate;

    @NotBlank
    private Long idCountry;

    @NotBlank
    private Long idGroup;

    // TODO add getters and setters.
}
