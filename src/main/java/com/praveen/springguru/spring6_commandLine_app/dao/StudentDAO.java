package com.praveen.springguru.spring6_commandLine_app.dao;

import com.praveen.springguru.spring6_commandLine_app.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    List<Student> findByPredicateName(String firstName,String lastName);
    List<Student> findByEmail(String email);
    void update(Student student);
    void delete(Integer studentId);
    int deleteStudentByLastName(String lastName);
}
