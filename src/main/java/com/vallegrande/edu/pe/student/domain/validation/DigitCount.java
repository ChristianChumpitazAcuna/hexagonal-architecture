package com.vallegrande.edu.pe.student.domain.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DigitCountValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DigitCount {
    String message() default "Must have {digits} digits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int digits() default 0;

    boolean nullable() default false;
}
