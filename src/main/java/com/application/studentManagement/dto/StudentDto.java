package com.application.studentManagement.dto;

import java.util.Date;

public class StudentDto {
    private int id;
    private String name;
    private String email;
    private float marksObtained;
    private Date admissionDate;
    private String grade;

    public StudentDto(){}

    public StudentDto(int id, String name, String email, float marksObtained, java.util.Date admissionDate, String grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.marksObtained = marksObtained;
        this.admissionDate = admissionDate;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(float marksObtained) {
        this.marksObtained = marksObtained;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
