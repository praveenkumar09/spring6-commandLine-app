package com.praveen.springguru.spring6_commandLine_app;

import com.praveen.springguru.spring6_commandLine_app.dao.StudentDAO;
import com.praveen.springguru.spring6_commandLine_app.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring6CommandLineAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring6CommandLineAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating Multiple Student.......");
		Student tmpStudent1 = new Student("Manu","Prasad","manu@gmail.com");
		Student tmpStudent2 = new Student("Mika","Prasad","mika@gmail.com");
		Student tmpStudent3 = new Student("Mayur","Prasad","mayur@gmail.com");

		System.out.println("Saving student Objects.....");
		studentDAO.save(tmpStudent1);
		studentDAO.save(tmpStudent2);
		studentDAO.save(tmpStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student....");
		Student tempStudent = new Student("Paul","Doe","pauldoe@gmail.com");
		studentDAO.save(tempStudent);
		System.out.println("New student created...."+tempStudent.getId());
	}

}
