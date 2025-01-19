package com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
