package com.application.studentManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.studentManagement.entity.Student;

@Repository
public interface studentRepository extends CrudRepository<Student,Integer>{
    
}
