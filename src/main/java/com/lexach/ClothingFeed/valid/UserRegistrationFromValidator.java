package com.lexach.ClothingFeed.valid;

import com.lexach.ClothingFeed.controller.form.UserRegistrationForm;
import com.lexach.ClothingFeed.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class UserRegistrationFromValidator implements Validator {

    private UserRepository userRepository;

    public UserRegistrationFromValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegistrationForm.class.equals(clazz);
    }

    /**
     * Validate User Registration Form
     * @param target user registration form.
     * @param errors errors.
     * Checking for:
     *               1) Unique username;
     *               2) Unique Email;
     *               3) Matching password and confirm password;
     *               4) Password length;
     */
    @Override
    public void validate(Object target, Errors errors) {
        // Creating UserRegistrationForm to validate.
        UserRegistrationForm userRegistrationForm = (UserRegistrationForm) target;


        // If form email is unique in not the database.
        if( !Objects.isNull(userRepository.findByEmail(userRegistrationForm.getEmail())) ) {
            errors.rejectValue("email", "user.registration.form.email.nonUnique");
        }

        // And form username unique in the database.
        if( !Objects.isNull(userRepository.findByUsername(userRegistrationForm.getUsername())) ) {
            errors.rejectValue("nickname", "user.registration.form.nickname.nonUnique");
        }

        // Check if passwords match
        if( !userRegistrationForm.getPassword().equals( userRegistrationForm.getConfirmPassword() )) {
            errors.rejectValue("password", "user.registration.form.password.passwordsDoNotMatch");
        }

        if(userRegistrationForm.getPassword().length() < 10) {
            errors.rejectValue("password", "user.registration.form.password.passwordLengthisTooSmall");
        }
    }
}
