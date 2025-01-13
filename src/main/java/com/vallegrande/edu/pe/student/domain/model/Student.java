package com.vallegrande.edu.pe.student.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private Long phone;
    private String address;
    private Long dni;
    private boolean status;
}
