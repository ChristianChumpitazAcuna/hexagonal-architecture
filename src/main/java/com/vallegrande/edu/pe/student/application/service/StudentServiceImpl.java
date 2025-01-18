package com.vallegrande.edu.pe.student.application.service;

import com.vallegrande.edu.pe.student.application.port.in.StudentServicePort;
import com.vallegrande.edu.pe.student.application.port.out.mapper.StudentRequestMapper;
import com.vallegrande.edu.pe.student.domain.model.dto.request.StudentRequest;
import com.vallegrande.edu.pe.student.domain.port.StudentPersistencePort;
import com.vallegrande.edu.pe.student.domain.model.Student;
import com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.exception.UniqueFiledViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentServicePort {
    private final StudentPersistencePort persistencePort;
    @Qualifier("studentRequestMapperImpl")
    private final StudentRequestMapper studentRequestMapper;

    @Override
    public Student createStudent(StudentRequest student) {
        validateUniqueFields(student);
        var studentToSave = studentRequestMapper.toDomain(student);
        return persistencePort.save(studentToSave);
    }

    @Override
    public Student updateStudent(Long id, StudentRequest student) {
        Student existingStudent = persistencePort.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        validateUniqueFields(student);

        existingStudent.setId(id);
        existingStudent.setName(student.getName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setDni(student.getDni());
        existingStudent.setStatus(true);

        return persistencePort.update(existingStudent);
    }

    @Override
    public Student getStudentById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return persistencePort.findAll();
    }

    @Override
    public List<Student> getStudentsByStatus(boolean status) {
        return persistencePort.findByStatus(status);
    }

    @Override
    public void changeStudentStatus(Long id, boolean status) {
        persistencePort.changeStatus(id, status);
    }

    @Override
    public List<Student> searchStudent(String searchTerm, boolean status) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return persistencePort.findByStatus(status);
        }
        return persistencePort.searchByTerm(searchTerm, status);
    }

    private void validateUniqueFields(StudentRequest student) {
        UniqueFiledViolationException exception = new UniqueFiledViolationException();

        if (persistencePort.existsByPhone(student.getPhone())) {
            exception.addFieldError("phone", "Phone already exists");
        }
        if (persistencePort.existsByEmail(student.getEmail())) {
            exception.addFieldError("email", "Email already exists");
        }
        if (persistencePort.existsByDni(student.getDni())) {
            exception.addFieldError("dni", "DNI already exists");
        }

        if (!exception.getFieldErrors().isEmpty()) {
            throw exception;
        }
    }

}
