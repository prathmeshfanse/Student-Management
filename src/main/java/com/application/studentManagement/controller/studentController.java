package com.application.studentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.studentManagement.dto.StudentDto;
import com.application.studentManagement.entity.Student;
import com.application.studentManagement.repository.StudentRepository;
import com.application.studentManagement.service.StudentService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    StudentService service;

    @Autowired
    StudentRepository repository;

    @PostMapping
    public StudentDto addStudent(@RequestBody StudentDto studentDto){

        StudentDto savedStudent = service.createStudent(studentDto);
        savedStudent.setGrade(studentDto.getGrade());

        return savedStudent;
        
    }

    @GetMapping("/allStudents")
    public List<StudentDto> getAllStudents() {
        return service.getAllStudents();
    }
    

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable int id){

        // if(service.getStudentById(id) == null)
        //     return null;

        return service.getStudentById(id);   
        }

    @GetMapping(params = "name")
    public StudentDto getStudentByName(@RequestParam String name){
        return service.getStudentByName(name);
    }

    @GetMapping(params = "email")
    public StudentDto getStudentByEmail(@RequestParam String email){
        return service.getStudentByEmail(email);
    }

    @PutMapping("/update/{id}")
    public boolean updateStudentById(@PathVariable int id, @RequestBody Student student) {
        // Student exist = repository.findById(id)
        //         .orElseThrow(() -> new RuntimeException());
        // exist.setEmail(student.getEmail());
        // exist.setAdmissionDate(student.getAdmissionDate());
        // exist.setName(student.getName());
        // exist.setMarksObtained(student.getMarksObtained());

        // return (repository.save(student)!=null);

        StudentDto student2 = service.getStudentById(id);

        if(student != null){
            student2.setAdmissionDate(student.getAdmissionDate());
            student2.setEmail(student.getEmail());
            student2.setMarksObtained(student.getMarksObtained());
            student2.setName(student.getName());
            repository.save(student);
            return true;
        }else{
            return false;
        }
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteStudentById(@PathVariable int id){
        // Student exiStudent = repository.findById(id)
        //         .orElseThrow(() -> new RuntimeException());

        // if(exiStudent == null)

        StudentDto student = service.getStudentById(id);

        if(student != null){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }

        
    }
}
