package com.vallegrande.edu.pe.student.application.service;

import com.vallegrande.edu.pe.student.application.port.in.StudentServicePort;
import com.vallegrande.edu.pe.student.application.port.out.mapper.StudentRequestMapper;
import com.vallegrande.edu.pe.student.domain.model.dto.request.StudentRequest;
import com.vallegrande.edu.pe.student.domain.repository.StudentRepository;
import com.vallegrande.edu.pe.student.domain.model.Student;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentServicePort {
    private final StudentRepository repository;
    @Qualifier("studentRequestMapperImpl")
    private final StudentRequestMapper mapper;

    @Override
    public Student createStudent(StudentRequest student) {
        var studentToSave = mapper.toDomain(student);
        return repository.save(studentToSave);
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
    public List<Student> getStudentsByStatus(boolean status) {
        return repository.findByStatus(status);
    }

    @Override
    @Transactional
    public void changeStudentStatus(Long id, boolean status) {
        repository.changeStatus(id, status);
    }


}
