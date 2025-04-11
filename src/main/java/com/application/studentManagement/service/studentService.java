package com.application.studentManagement.service;

import java.util.List;

import com.application.studentManagement.entity.Student;


public interface studentService {
    public Student createStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public Student getStudentByName(String name);
    public Student getStudentByEmail(String mail);
   // public Student updateStudentById(int id,Student student);
}