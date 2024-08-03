package com.praveen.springguru.spring6_commandLine_app.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    /**
     * Generation strategies for the primary key:
     * AUTO : Pick an appropriate strategy for a particular database
     * IDENTITY : Assign primary key using database identity column
     * SEQUENCE : Assign primary key using a database sequence
     * TABLE : Assign primary key using an underlying table
     * UUID : Assign primary key using a globally unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


}
