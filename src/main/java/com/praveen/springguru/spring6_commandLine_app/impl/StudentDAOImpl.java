package com.praveen.springguru.spring6_commandLine_app.impl;


import com.praveen.springguru.spring6_commandLine_app.dao.StudentDAO;
import com.praveen.springguru.spring6_commandLine_app.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.lastName = :lastName", Student.class)
                .setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<Student> findByPredicateName(String firstName, String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.firstName = :firstName OR s.lastName = :lastName", Student.class)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<Student> findByEmail(String email) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.email LIKE :email", Student.class)
                .setParameter("email", "%" + email + "%");
        return query.getResultList();
    }
}
