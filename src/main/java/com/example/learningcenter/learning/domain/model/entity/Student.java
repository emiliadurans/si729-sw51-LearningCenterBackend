package com.example.learningcenter.learning.domain.model.entity;


import com.example.learningcenter.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity //va a ser persistente
@Table(name = "students")
public class Student extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 80)
    @Column(unique = true)
    private String name;

    private int age;

    @Size(max = 240)

    private String address;

}
