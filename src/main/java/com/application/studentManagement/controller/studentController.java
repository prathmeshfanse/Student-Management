package com.application.studentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.studentManagement.entity.Student;
import com.application.studentManagement.service.studentService;

@RestController
@RequestMapping("/students")
public class studentController {
    
    @Autowired
    studentService service;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return service.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return service.getStudentById(id);    }
}
