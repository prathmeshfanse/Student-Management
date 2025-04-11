package com.application.studentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.studentManagement.entity.Student;

@Repository
public interface studentRepository extends JpaRepository<Student,Integer>{
    public Student getStudentByName(String name);
    public Student getStudentByEmail(String mail);
}
