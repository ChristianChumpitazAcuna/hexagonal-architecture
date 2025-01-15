package com.vallegrande.edu.pe.student.infraestructure.adapter.in.rest.exception;

public class UniqueFiledViolationException extends RuntimeException {
    public UniqueFiledViolationException(String message) {
        super(message);
    }
}
