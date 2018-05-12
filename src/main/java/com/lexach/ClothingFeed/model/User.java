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
@Table(name = "User")
// EntityListener для инжекта значения в поля под аннотацией @CreatedDate.
@EntityListeners(AuditingEntityListener.class)

// Это Jackson аннотация. Spring Boot использует Jackson для сериализации и десериализации Java объектов в и из JSON-а.
// Эта аннотация используется т.к. мы не хотим, чтобы клиенты rest api парились с предоставлением значиний createdAt и updatedAt.
// Если они предоставляют данные значения, мы просто их игнорим. Тем не менее, мы включаем эти значения в JSON response.
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPasswordHashSum() {
        return passwordHashSum;
    }

    public void setPasswordHashSum(String passwordHashSum) {
        this.passwordHashSum = passwordHashSum;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Enum getGender() {
        return gender;
    }

    public void setGender(Enum gender) {
        this.gender = gender;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

}
