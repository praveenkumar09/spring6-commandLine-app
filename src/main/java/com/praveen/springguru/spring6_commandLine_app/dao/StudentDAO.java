package com.praveen.springguru.spring6_commandLine_app.dao;

import com.praveen.springguru.spring6_commandLine_app.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
}
