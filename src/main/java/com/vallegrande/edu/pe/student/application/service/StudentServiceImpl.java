package com.vallegrande.edu.pe.student.application.service;

import com.vallegrande.edu.pe.student.application.port.in.StudentServicePort;
import com.vallegrande.edu.pe.student.application.port.out.mapper.StudentRequestMapper;
import com.vallegrande.edu.pe.student.domain.model.dto.request.StudentRequest;
import com.vallegrande.edu.pe.student.domain.repository.StudentRepository;
import com.vallegrande.edu.pe.student.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentServicePort {
    private final StudentRepository repository;
    @Qualifier("studentRequestMapperImpl")
    private final StudentRequestMapper mapperForCreate;

    @Override
    public Student createStudent(StudentRequest student) {
        var studentToSave = mapperForCreate.toDomain(student);
        return repository.save(studentToSave);
    }

    @Override
    public Student updateStudent(Long id, StudentRequest student) {
        Student existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setId(id);
        existingStudent.setName(student.getName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setDni(student.getDni());
        existingStudent.setStatus(true);

        return repository.update(existingStudent);
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
    public void changeStudentStatus(Long id, boolean status) {
        repository.changeStatus(id, status);
    }

    @Override
    public List<Student> searchStudent(String searchTerm, boolean status) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return repository.findByStatus(status);
        }
        return repository.searchByTerm(searchTerm, status);
    }
}
