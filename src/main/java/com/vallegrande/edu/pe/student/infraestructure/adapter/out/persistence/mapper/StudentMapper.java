package com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.mapper;

import com.vallegrande.edu.pe.student.domain.model.Student;
import com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toDomain(StudentEntity studentEntity);

    StudentEntity toEntity(Student student);
}
