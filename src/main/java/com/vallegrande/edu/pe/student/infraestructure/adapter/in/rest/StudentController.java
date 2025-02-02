package com.vallegrande.edu.pe.student.infraestructure.adapter.in.rest;

import com.vallegrande.edu.pe.student.application.port.in.StudentServicePort;
import com.vallegrande.edu.pe.student.domain.model.Student;
import com.vallegrande.edu.pe.student.domain.model.dto.request.StudentRequest;
import jakarta.validation.Valid;
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
    public ResponseEntity<Student> create(@Valid @RequestBody StudentRequest student) {
        return ResponseEntity.ok(studentServicePort.createStudent(student));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @Valid @RequestBody StudentRequest student) {
        return ResponseEntity.ok(studentServicePort.updateStudent(id, student));
    }

    @PutMapping("changeStatus/{status}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id, @PathVariable boolean status) {
        studentServicePort.changeStudentStatus(id, status);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentServicePort.getStudentById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentServicePort.getAllStudents());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Student>> getAllByStatus(@PathVariable boolean status) {
        return ResponseEntity.ok(studentServicePort.getStudentsByStatus(status));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> search(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) boolean status
    ) {
        return ResponseEntity.ok(studentServicePort.searchStudent(searchTerm, status));
    }
}
