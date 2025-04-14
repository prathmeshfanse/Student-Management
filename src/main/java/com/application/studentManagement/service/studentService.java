package com.application.studentManagement.service;

import java.util.List;

import com.application.studentManagement.dto.StudentDto;


public interface StudentService {
    public StudentDto createStudent(StudentDto StudentDto);
    public List<StudentDto> getAllStudents();
    public StudentDto getStudentById(int id);
    public StudentDto getStudentByName(String name);
    public StudentDto getStudentByEmail(String mail);
   // public Student updateStudentById(int id,Student student);
}