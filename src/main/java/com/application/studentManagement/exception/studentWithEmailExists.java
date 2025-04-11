package com.application.studentManagement.exception;

import com.application.studentManagement.entity.Student;

public class studentWithEmailExists extends RuntimeException{

    public studentWithEmailExists(Student student){
        System.out.println("Student with an "+student.getEmail()+" already Exists");
    }

}
