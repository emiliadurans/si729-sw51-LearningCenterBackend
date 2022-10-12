package com.example.learningcenter.learning.api;

import com.example.learningcenter.learning.domain.model.entity.Student;
import com.example.learningcenter.learning.domain.service.StudentService;
import com.example.learningcenter.learning.mapping.StudentMapper;
import com.example.learningcenter.learning.resource.CreateStudentResource;
import com.example.learningcenter.learning.resource.StudentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/students", produces = "application/json")
public class StudentsController {
    private final StudentService studentService;

    private final StudentMapper mapper;

    public StudentsController(StudentService studentService, StudentMapper mapper) {
        this.studentService = studentService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<StudentResource> getAllStudents(Pageable pageable) {
        return mapper.modelListPage(studentService.getAll(),pageable);
    }

    @GetMapping("{studentId}")
    public StudentResource getStudentById(@PathVariable Long studentId) {
        return mapper.toResource(studentService.getById(studentId));
    }

    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource){
        return new ResponseEntity<>(
                mapper.toResource(
                        studentService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
