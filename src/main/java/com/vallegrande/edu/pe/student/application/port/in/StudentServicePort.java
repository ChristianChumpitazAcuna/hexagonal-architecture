package com.vallegrande.edu.pe.student.application.port.in;

import com.vallegrande.edu.pe.student.domain.model.Student;
import com.vallegrande.edu.pe.student.domain.model.dto.request.StudentRequest;

import java.util.List;

public interface StudentServicePort {
    Student createStudent(StudentRequest student);

    Student updateStudent(Long id, StudentRequest student);

    Student getStudentById(Long id);

    List<Student> getAllStudents();

    List<Student> getStudentsByStatus(boolean status);

    void changeStudentStatus(Long id, boolean status);

    List<Student> searchStudent(String searchTerm, boolean status);
}
