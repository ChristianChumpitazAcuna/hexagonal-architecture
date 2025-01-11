package com.vallegrande.edu.pe.student.infraestructure.adapter.in.rest;

import com.vallegrande.edu.pe.student.application.port.in.StudentServicePort;
import com.vallegrande.edu.pe.student.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServicePort studentServicePort;

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.ok(studentServicePort.createStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentServicePort.getStudentById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentServicePort.getAllStudents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        studentServicePort.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}
