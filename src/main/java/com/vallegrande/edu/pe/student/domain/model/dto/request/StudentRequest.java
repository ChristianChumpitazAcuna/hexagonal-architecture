package com.vallegrande.edu.pe.student.domain.model.dto.request;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    @NotNull
    @Size(min = 3, max = 50)
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String name;

    @NotNull
    @Size(min = 3, max = 50)
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String lastName;

    @NotNull
    @Size(min = 10, max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
    private String email;

    @NotNull
//    @Min(9)
//    @Max(9)
    private Long phone;

    @NotNull
    @Size(min = 10, max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$")
    private String address;

    @NotNull
//    @Min(8)
//    @Max(8)
    private Long dni;
}
