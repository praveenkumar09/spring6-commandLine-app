package com.praveen.springguru.spring6_commandLine_app.impl;


import com.praveen.springguru.spring6_commandLine_app.dao.StudentDAO;
import com.praveen.springguru.spring6_commandLine_app.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
