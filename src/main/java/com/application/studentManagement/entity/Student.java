package com.application.studentManagement.entity;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique=true)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    private float marksObtained;
    
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date admissionDate;

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

    @Override
    public String toString() {
        return "student [id=" + id + ", name=" + name + ", email=" + email + ", marksObtained=" + marksObtained
                + ", admissionDate=" + admissionDate + "]";
    }

}
