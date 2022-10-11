package com.example.learningcenter.learning.domain.service;

import com.example.learningcenter.learning.domain.model.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

// en repositorios se usa FIND en service se usa GET
public interface StudentService {
    List<Student> getAll();
    Page<Student> getAll(Pageable pageable);
    Student getById(Long studentId);
    Student create(Student student);
    Student update(Long studentId, Student request);
    ResponseEntity<?> delete(Long studentId);
}
