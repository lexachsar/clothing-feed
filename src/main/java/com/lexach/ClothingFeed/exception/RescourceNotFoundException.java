package com.lexach.ClothingFeed.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Когда этот эксепшн вылетит, спринг ответит юзеру данным статусом.
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RescourceNotFoundException extends RuntimeException {
    private String rescourceName;
    private String fieldName;
    private Object fieldValue;

    public RescourceNotFoundException(String rescourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", rescourceName, fieldName, fieldValue));

        this.rescourceName = rescourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }


    public String getRescourceName() {
        return rescourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
