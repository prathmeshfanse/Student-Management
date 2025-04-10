package com.application.studentManagement.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.application.studentManagement.entity.Student;


public interface studentService {
    public Student createStudent(Student student);
    public Student getStudentById(int id);
    
}
