package com.example.learningcenter.learning.domain.persistence;

import com.example.learningcenter.learning.domain.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//JPA Repository tiene metodos tipo sql (get, find, etc) +

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByAge(int age); //metodo de filtracion
    Student findByName(String name);

}
