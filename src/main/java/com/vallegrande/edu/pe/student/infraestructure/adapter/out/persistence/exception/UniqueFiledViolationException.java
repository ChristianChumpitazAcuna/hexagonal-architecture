package com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.exception;


import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class UniqueFiledViolationException extends RuntimeException {
    private final Map<String, String> fieldErrors;

    public UniqueFiledViolationException() {
        fieldErrors = new HashMap<>();
    }

    public void addFieldError(String field, String value) {
        fieldErrors.put(field, value);
    }

}
