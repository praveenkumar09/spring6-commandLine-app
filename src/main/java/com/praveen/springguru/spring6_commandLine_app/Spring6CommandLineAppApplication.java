package com.praveen.springguru.spring6_commandLine_app;

import com.praveen.springguru.spring6_commandLine_app.dao.StudentDAO;
import com.praveen.springguru.spring6_commandLine_app.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Spring6CommandLineAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring6CommandLineAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudentById(studentDAO);
			//deleteStudentByLastName(studentDAO);
		};
	}

	private void deleteStudentByLastName(StudentDAO studentDAO) {
		System.out.println("Delete student by last name....");
		int numOfRows = studentDAO.deleteStudentByLastName("Doe");
		System.out.println("No of students deleted..."+numOfRows);
	}

	private void deleteStudentById(StudentDAO studentDAO) {
		studentDAO.delete(3);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student student = studentDAO.findById(studentId);
		System.out.println("Updated student with id: " + studentId);
		student.setFirstName("Scooby");
		student.setEmail("scooby@gmail.com");
		studentDAO.update(student);
		System.out.println("Updated student: " + student);
	}

	private void queryByLastName(StudentDAO studentDAO) {
		System.out.println("Querying by the last name...");
		List<Student> students = studentDAO.findByLastName("Doe");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		System.out.println("Querying for students....");
		List<Student> students = studentDAO.findAll();
		for(Student student : students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student....");
		Student tempStudent = new Student("Sebastin","Doe","sebastin@gmail.com");
		studentDAO.save(tempStudent);
		System.out.println("New student created...."+tempStudent.getId());
		System.out.println("Reading student...."+tempStudent.getId());
		Student sebaStudent = studentDAO.findById(tempStudent.getId());
		System.out.println("Found student...."+sebaStudent);
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
