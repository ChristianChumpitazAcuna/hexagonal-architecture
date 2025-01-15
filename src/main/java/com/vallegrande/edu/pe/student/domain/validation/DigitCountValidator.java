package com.vallegrande.edu.pe.student.domain.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DigitCountValidator implements ConstraintValidator<DigitCount, Number> {

    private int expectedDigits;
    private boolean allowNull;
    private String message;

    @Override
    public void initialize(DigitCount constraintAnnotation) {
        this.expectedDigits = constraintAnnotation.digits();
        this.allowNull = constraintAnnotation.nullable();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Number number, ConstraintValidatorContext context) {
        if (number == null) return allowNull;

        String numStr = number.toString();
        boolean isValid = numStr.length() == expectedDigits;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    message.replace("{digits}", String.valueOf(expectedDigits))
            ).addConstraintViolation();
        }

        return isValid;
    }
}
