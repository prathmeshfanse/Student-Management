package com.application.studentManagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.time.LocalDate;
import java.util.Date;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.application.studentManagement.dto.StudentDto;
import com.application.studentManagement.entity.Student;
import com.application.studentManagement.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl service;

    @Mock
    private StudentRepository repository;
    
    private Student student;

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImplTest.class);


    @BeforeEach
    void setup(){
        student = new Student();
        student.setId(1);
        student.setName("Test Student");
        student.setEmail("test@example.com");
        student.setMarksObtained(0f);
        student.setAdmissionDate(new Date());
    }

    @Test
    void testGradePlatinumAndOldAdmission(){
        student.setMarksObtained(90.0f);
        student.setAdmissionDate(java.sql.Date.valueOf(LocalDate.now().minusMonths(6)));

        when(repository.getStudentByEmail("test@example.com")).thenReturn(student);
        
        StudentDto studentDto = service.getStudentByEmail("test@example.com");

        assertEquals("Platinum", studentDto.getGrade());
        
        logger.info("✔ testGradePlaatinumAndOldAdmission passed: Grade is Platinum");

    }

    @Test
    void testGradeMerit(){
        student.setMarksObtained(85.5f);
        student.setAdmissionDate(java.sql.Date.valueOf(LocalDate.now()));

        when(repository.getStudentByName("Test Student")).thenReturn(student);

        StudentDto studentDto = service.getStudentByName("Test Student");

        assertEquals("Merit", studentDto.getGrade());
        assertEquals(LocalDate.now(), ((java.sql.Date) studentDto.getAdmissionDate()).toLocalDate());

        logger.info("✔ testGradeMerit passed: Grade is Merit");
    }

    @Test
    void testGradePass(){
        student.setMarksObtained(55.5f);
        student.setAdmissionDate(java.sql.Date.valueOf(LocalDate.now()));

        when(repository.getStudentByEmail("test@example.com")).thenReturn(student);

        StudentDto studentDto = service.getStudentByEmail("test@example.com");

        assertEquals("Pass", studentDto.getGrade());
        assertEquals(LocalDate.now(), ((java.sql.Date) studentDto.getAdmissionDate()).toLocalDate());

        logger.info("✔ testGradePass passed: Grade is Pass");

    }

    @Test
    void testGradeFail(){
        student.setMarksObtained(30.76f);
        student.setAdmissionDate(java.sql.Date.valueOf(LocalDate.now()));

        when(repository.getStudentByName("Test Student")).thenReturn(student);

        StudentDto studentDto = service.getStudentByName("Test Student");

        assertEquals("Fail", studentDto.getGrade());
        assertEquals(LocalDate.now(), ((java.sql.Date) studentDto.getAdmissionDate()).toLocalDate());

        logger.info("✔ testGradeFail passed: Grade is Fail");
    }
}
