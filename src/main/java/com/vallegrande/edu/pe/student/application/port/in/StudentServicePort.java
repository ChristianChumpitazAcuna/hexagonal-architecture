package com.vallegrande.edu.pe.student.application.port.in;

import com.vallegrande.edu.pe.student.domain.model.Student;

import java.util.List;

public interface StudentServicePort {
    Student createStudent(Student student);

    Student getStudentById(Long id);

    List<Student> getAllStudents();

    List<Student> getStudentsByStatus(boolean status);

    void changeStudentStatus(Long id, boolean status);
}
