package com.lexach.ClothingFeed.controller.validation;

import com.lexach.ClothingFeed.model.User;
import com.lexach.ClothingFeed.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

@Component
public class RegistrationValidator implements Validator {

    private UserRepository repository;

    public RegistrationValidator(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // TODO Add Validation.
        // TODO ??? Как сделать валидацию на пароль (в валидатор передается уже готовая модель без второго поля для пароля.) ???
    }
}
