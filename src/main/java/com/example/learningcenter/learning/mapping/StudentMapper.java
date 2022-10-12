package com.example.learningcenter.learning.mapping;

import com.example.learningcenter.learning.domain.model.entity.Student;
import com.example.learningcenter.learning.resource.CreateStudentResource;
import com.example.learningcenter.learning.resource.StudentResource;
import com.example.learningcenter.learning.resource.UpdateStudentResource;
import com.example.learningcenter.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class StudentMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public StudentResource toResource(Student model) {
        return mapper.map(model, StudentResource.class);
    }

    public Student toModel(CreateStudentResource resource){
        return mapper.map(resource, Student.class);
    }

    public Student toModel(UpdateStudentResource resource){
        return mapper.map(resource, Student.class);
    }

    public Page<StudentResource> modelListPage(List<Student> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,StudentResource.class),pageable,modelList.size());
    }
}
