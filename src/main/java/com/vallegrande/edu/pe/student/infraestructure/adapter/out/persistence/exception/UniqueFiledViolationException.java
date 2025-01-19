package com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
public class UniqueFiledViolationException extends RuntimeException {
    private final ApiError apiError;

    public UniqueFiledViolationException() {
        this.apiError = new ApiError(HttpStatus.BAD_REQUEST);
    }

    public void addFieldError(String field, String value) {
        apiError.addError(field, value);
    }

    public Map<String, String> getFieldErrors() {
        return apiError.getErrors();
    }
}
