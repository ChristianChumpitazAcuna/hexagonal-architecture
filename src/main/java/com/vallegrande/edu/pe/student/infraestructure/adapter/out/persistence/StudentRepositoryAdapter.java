package com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence;

import com.vallegrande.edu.pe.student.domain.repository.StudentRepository;
import com.vallegrande.edu.pe.student.domain.model.Student;
import com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.entity.StudentEntity;
import com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.mapper.StudentMapper;
import com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.repository.StudentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentRepositoryAdapter implements StudentRepository {

    private final StudentJpaRepository studentJpaRepository;
    private final StudentMapper studentMapper;

    @Override
    public Student save(Student student) {
        StudentEntity entity = studentMapper.toEntity(student);
        return studentMapper.toDomain(studentJpaRepository.save(entity));
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentJpaRepository.findById(id)
                .map(studentMapper::toDomain);
    }

    @Override
    public List<Student> findAll() {
        return studentJpaRepository.findAll()
                .stream()
                .map(studentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        studentJpaRepository.deleteById(id);
    }
}
