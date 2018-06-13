package com.lexach.ClothingFeed.controller.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationForm {

    // TODO Add regexp Email validation.
    @NotBlank(message = "Please, fill email field.")
    @NotNull(message = "Please, fill email field.")
    private String email;

    @NotBlank(message = "Please, fill username field.")
    @NotNull(message = "Please, fill username field.")
    private String username;

    @NotBlank(message = "Please, fill password field.")
    @NotNull(message = "Please, fill password field.")
    @Size(min = 7, max = 30, message = "Password must have between 7 and 30 symbols.")
    private String password;

    @NotBlank(message = "Please, confirm password.")
    @NotNull(message = "Please, confirm password.")
    @Size(min = 7, max = 30, message = "Password must have between 7 and 30 symbols.")
    private String confirmPassword;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "UserRegistrationForm{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}