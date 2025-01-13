package com.vallegrande.edu.pe.student.application.port.out.mapper;

import com.vallegrande.edu.pe.student.domain.model.Student;
import com.vallegrande.edu.pe.student.domain.model.dto.request.StudentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentRequestMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "dni", target = "dni")
    Student toDomain(StudentRequest studentRequest);
}
