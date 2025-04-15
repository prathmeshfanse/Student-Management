package com.application.studentManagement.exception;

import com.application.studentManagement.entity.Student;

public class StudentWithEmailAlreadyExists extends RuntimeException{

    public StudentWithEmailAlreadyExists(String message){
        super(message);
    }
}
