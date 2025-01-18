package com.vallegrande.edu.pe.student.domain.port;

import com.vallegrande.edu.pe.student.domain.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentPersistencePort {
    Student save(Student student);

    Student update(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();

    List<Student> findByStatus(boolean status);

    void changeStatus(Long id, boolean status);

    List<Student> searchByTerm(String searchTerm, boolean status);

    boolean existsByPhone(Long phone);

    boolean existsByEmail(String email);

    boolean existsByDni(Long dni);
}
