package com.application.studentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.studentManagement.entity.Student;
import com.application.studentManagement.repository.studentRepository;

@Service
public class studentServiceImpl implements studentService{

    @Autowired
    studentRepository repository;

    @Override
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }
}
