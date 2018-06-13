package com.lexach.ClothingFeed.controller.valid;

import com.lexach.ClothingFeed.controller.form.UserRegistrationForm;
import com.lexach.ClothingFeed.model.User;
import com.lexach.ClothingFeed.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class UserRegistrationFormValidator implements Validator {

    private UserRepository userRepository;

    public UserRegistrationFormValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegistrationForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserRegistrationForm form = (UserRegistrationForm) target;

        validateEmail(form.getEmail(), errors);

        validateUsername(form.getUsername(), errors);

    }

    /**
     * Validate @param username from user form.
     */
    private void validateUsername(String username, Errors errors) {
        User databaseUser = userRepository.findByUsername(username);
        if (Objects.nonNull(databaseUser)) {
            errors.rejectValue("username", "databaseUser.username.nonUnique", "User with this username already exists.");
        }
    }

    /**
     * Validate @param email from user form.
     */
    private void validateEmail(String email, Errors errors) {
        User databaseUser = userRepository.findByEmail(email);
        if (Objects.nonNull(databaseUser)) {
            errors.rejectValue("email", "databaseUser.email.nonUnique", "User with this email already exists.");
        }
    }


}
