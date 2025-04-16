package com.application.studentManagement.service;

import java.util.List;

import com.application.studentManagement.dto.StudentDto;
import com.application.studentManagement.entity.Student;


public interface StudentService {
    public StudentDto createStudent(StudentDto StudentDto);
    public List<StudentDto> getAllStudents();
    public StudentDto getStudentById(int id);
    public StudentDto getStudentByName(String name);
    public StudentDto getStudentByEmail(String mail);
   // public Student updateStudentById(int id,Student student);
    public boolean deleteById(int id);
    public boolean save(Student student);
}