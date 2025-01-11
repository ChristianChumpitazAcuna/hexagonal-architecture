package com.vallegrande.edu.pe.student.application.service;

import com.vallegrande.edu.pe.student.application.port.in.StudentServicePort;
import com.vallegrande.edu.pe.student.domain.repository.StudentRepository;
import com.vallegrande.edu.pe.student.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentServicePort {
    private final StudentRepository repository;

    @Override
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public void deleteStudentById(Long id) {
        repository.deleteById(id);
    }
}
