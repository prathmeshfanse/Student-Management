package com.application.studentManagement.service;

import java.util.List;

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

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) repository.findAll();
    }

    @Override
    public Student getStudentByName(String name) {
        return repository.getStudentByName(name);
    }

    @Override
    public Student getStudentByEmail(String mail) {
        return repository.getStudentByEmail(mail);
    }

    // @Override
    // public Student updateStudentById(int id,Student student) {
    //     if(repository.findById(id) != null){
    //         return repository.updateStudentById(id, student);
    //     }

    //     return null;

    // }
}
