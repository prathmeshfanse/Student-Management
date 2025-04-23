package com.application.studentManagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.sql.Date;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.studentManagement.dto.StudentDto;
import com.application.studentManagement.entity.Student;
import com.application.studentManagement.repository.StudentRepository;
import com.application.studentManagement.service.StudentService;
import com.application.studentManagement.service.StudentServiceImplTest;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private StudentRepository repository;

    @Mock
    private StudentService service;

    @InjectMocks
    private StudentController studentController;
    
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImplTest.class);

    private StudentDto student1;
    private StudentDto student2;
        
    @BeforeEach
    void setUp() {
        student1 = new StudentDto();
        student1.setId(1);
        student1.setName("John");
        student1.setMarksObtained(68.0f);
        student1.setEmail("John@gmail.com");
        student1.setGrade("Pass");

        student2 = new StudentDto();
        student2.setId(2);
        student2.setName("Rohn");
        student2.setMarksObtained(88.0f);
        student2.setEmail("Rohn@gmail.com");
        student2.setGrade("Platinum");
    }

    @Test
    public void testAddStudent() throws Exception {
        when(service.createStudent(student1)).thenReturn(student1);

        StudentDto result = studentController.addStudent(student1);

        assertEquals("John", result.getName());
        assertEquals(68.0f, result.getMarksObtained());
        assertEquals("John@gmail.com", result.getEmail());
        assertEquals("Pass", result.getGrade());

        logger.info("Test case testAddStudent passed");
    }

    @Test
    public void testGetAllStudents() {
        List<StudentDto> expected = Arrays.asList(student1, student2);
        when(service.getAllStudents()).thenReturn(expected);

        List<StudentDto> actual = studentController.getAllStudents();

        assertEquals(2, actual.size());
        assertEquals("John", actual.get(0).getName());
        assertEquals("Rohn", actual.get(1).getName());

        
        logger.info("Test case testGetAllStudents passed");
    }

    @Test
    public void testGetStudentById() {
        int id = 1;
        when(service.getStudentById(id)).thenReturn(student1);

        StudentDto actual = studentController.getStudentById(id);

        assertEquals(id, actual.getId());
        assertEquals("John", actual.getName());
        assertEquals(68.0f, actual.getMarksObtained());
        assertEquals("John@gmail.com", actual.getEmail());
        assertEquals("Pass", actual.getGrade());

        logger.info("Test case testGetStudentById passed");
    }

    @Test
    public void testupdateStudentById(){
        int id = 1;

        // Student student1 = new Student();
        // student1.setId(1);
        // student1.setName("John");
        // student1.setMarksObtained(68.0f);
        // student1.setEmail("John@gmail.com");

        StudentDto updatedStudent = new StudentDto();
        updatedStudent.setName("Updated Name");
        updatedStudent.setEmail("updated@example.com");
        updatedStudent.setMarksObtained(90.0f);
        updatedStudent.setAdmissionDate(Date.valueOf(LocalDate.now().minusMonths(7)));
        updatedStudent.setGrade("Merit");
            
       // when(service.getStudentById(1)).thenReturn(student1);
        when(service.updateStudentById(1, updatedStudent)).thenReturn(true);

        boolean result = studentController.updateStudentById(1, updatedStudent);

        assertEquals(true, result);

        
        logger.info("Test case testupdateStudentById passed");
    }

    @Test
    public void testdeleteStudentById_success(){

        when(service.getStudentById(1)).thenReturn(student1);
        when(service.deleteById(1)).thenReturn(true);

        boolean result = studentController.deleteStudentById(1);

        assertEquals(true, result);

        logger.info("Test case testdeleteStudentById_success passed");
    }

    @Test
    public void testDeleteStudentById_notFound(){

        when(service.getStudentById(100)).thenReturn(null);

        boolean result = studentController.deleteStudentById(100);

        assertEquals(false, result);

        logger.info("Test case testDeleteStudentById_notFound passed");

    }

}


