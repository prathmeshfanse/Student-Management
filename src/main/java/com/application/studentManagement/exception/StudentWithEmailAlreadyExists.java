package com.application.studentManagement.exception;


public class StudentWithEmailAlreadyExists extends RuntimeException{

    public StudentWithEmailAlreadyExists(String message){
        super(message);
    }
}
