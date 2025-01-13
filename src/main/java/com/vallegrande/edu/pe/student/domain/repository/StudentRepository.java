package com.vallegrande.edu.pe.student.domain.repository;

import com.vallegrande.edu.pe.student.domain.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();

    List<Student> findByStatus(boolean status);

    void changeStatus(Long id, boolean status);
}
