package com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        ex.getBindingResult().getFieldErrors().forEach(error ->
                apiError.addError(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError.getErrors());
    }

    @ExceptionHandler(UniqueFiledViolationException.class)
    public ResponseEntity<ApiError> handleUniqueFieldViolationException(UniqueFiledViolationException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        ex.getFieldErrors().forEach(apiError::addError);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}
