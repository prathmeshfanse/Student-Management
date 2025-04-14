package com.application.studentManagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.studentManagement.dto.StudentDto;
import com.application.studentManagement.entity.Student;
import com.application.studentManagement.repository.*;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository repository;

    //Entity->dto
    private StudentDto convertToDto(Student student){
        return new StudentDto(student.getId(), student.getName(), student.getEmail(), student.getMarksObtained(), student.getAdmissionDate(),"");
    }

    //dto->Entity
    private Student convertToEntity(StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setAdmissionDate(studentDto.getAdmissionDate());
        student.setEmail(studentDto.getEmail());
        student.setMarksObtained(studentDto.getMarksObtained());
        student.setName(studentDto.getName());

        return student;
    }

    @Override
    public StudentDto createStudent(StudentDto StudentDto) {
        Student student = convertToEntity(StudentDto);

        return convertToDto(repository.save(student));
    }
      /*  
    @Override
    public Student createStudent(StudentDto studentDto) {
        return repository.save(null)
    }*/


    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = repository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();

        for(Student student : students){
            StudentDto studentDto = convertToDto(student);
            LocalDate studentAdmissionDate = LocalDate.of(student.getAdmissionDate().getYear(), student.getAdmissionDate().getMonth()+1, student.getAdmissionDate().getDay()+1);
            LocalDate sixMonthAgo = LocalDate.now().minusMonths(6);

            if(student.getMarksObtained()>=90 && studentAdmissionDate.isBefore(sixMonthAgo)){
                studentDto.setGrade("Platinum");
            }else if(student.getMarksObtained()>=80 && student.getMarksObtained()<90){
                studentDto.setGrade("Merit");
            }else if(student.getMarksObtained()>40){
                studentDto.setGrade("Pass");
            }else{
                studentDto.setGrade("Fail");
            }
        
            studentDtos.add(studentDto);
        }

        return studentDtos;
    }


    /*
    @Override
    public List<StudentDto> getAllStudents() {
        return (List<StudentDto>) repository.findAll();
    } */

        
    @Override
    public StudentDto getStudentById(int id) {
        Student student =  repository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        
        return convertToDto(student);
   
    }

/*
    @Override
    public StudentDto getStudentById(int id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }*/

    
    @Override
    public StudentDto getStudentByName(String name) {
        Student student = repository.getStudentByName(name);

        return convertToDto(student);
    }
    /*
    @Override
    public StudentDto getStudentByName(String name) {
        return repository.getStudentByName(name);
    }*/

    @Override
    public StudentDto getStudentByEmail(String mail) {
        Student student = repository.getStudentByEmail(mail);

        return convertToDto(student);
    }

/*
    @Override
    public StudentDto getStudentByEmail(String mail) {
        return repository.getStudentByEmail(mail);
    }

    @Override
    public Student updateStudentById(int id,Student student) {
        if(repository.findById(id) != null){
            return repository.updateStudentById(id, student);
        }

        return null;

    }*/


}
