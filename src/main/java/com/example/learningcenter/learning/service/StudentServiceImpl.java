package com.example.learningcenter.learning.service;

import com.example.learningcenter.learning.domain.model.entity.Student;
import com.example.learningcenter.learning.domain.persistence.StudentRepository;
import com.example.learningcenter.learning.domain.service.StudentService;
import com.example.learningcenter.shared.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService { //implementa metodos
    private static final String ENTITY = "Student";
    private final StudentRepository studentRepository;
    private final Validator validator;
    public StudentServiceImpl(StudentRepository studentRepository, Validator validator) {
        this.studentRepository = studentRepository;
        this.validator = validator;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, studentId));
    }

    @Override
    public Student create(Student student) {
        return null;
    }

    @Override
    public Student update(Long studentId, Student request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long studentId) {
        return null;
    }
}
