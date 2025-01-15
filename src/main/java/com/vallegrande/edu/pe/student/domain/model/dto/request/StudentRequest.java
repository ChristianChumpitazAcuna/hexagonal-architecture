package com.vallegrande.edu.pe.student.domain.model.dto.request;


import com.vallegrande.edu.pe.student.domain.validation.DigitCount;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    @NotNull(message = "Name is required")
    @Size(min = 3, max = 50)
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "Name must have only letters")
    private String name;

    @NotNull(message = "Last name is required")
    @Size(min = 8, max = 80)
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "Last name must have only letters")
    private String lastName;

    @NotNull(message = "Email is required")
    @Size(min = 10, max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email must have a valid format")
    private String email;

    @DigitCount(digits = 9, message = "Phone must have {digits} digits")
    private Long phone;

    @NotNull(message = "Address is required")
    @Size(min = 10, max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]+$", message = "Address must have only letters and numbers")
    private String address;

    @DigitCount(digits = 8, message = "DNI must have {digits} digits")
    private Long dni;
}
