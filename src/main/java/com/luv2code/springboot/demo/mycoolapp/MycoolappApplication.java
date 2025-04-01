package com.luv2code.springboot.demo.mycoolapp;

import com.luv2code.springboot.demo.mycoolapp.dao.AccountDAO;
import com.luv2code.springboot.demo.mycoolapp.dao.StudentDAO;
import com.luv2code.springboot.demo.mycoolapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/* @SpringBootApplication(
		scanBasePackages = {"com.luv2code.springboot.demo.mycoolapp", "utils"}
) */

@SpringBootApplication
public class MycoolappApplication {
	@Autowired
	private StudentDAO studentDAO;

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			//demoTheBeforeAdvice(theAccountDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + numRowsDeleted + " rows");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3023;
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student tempStudent = studentDAO.findId(studentId);
		tempStudent.setFirstname("Daddy");
		tempStudent.setLastname("Dodd");
		studentDAO.update(tempStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Duck");
		for (Student theStudent : students) {
			System.out.println(theStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		System.out.println("queryForStudents()");
		for (Student theStudent : students) {
	//	for (Student theStudent : studentDAO.findAll()) {
			System.out.println(theStudent);
		}
	}


	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student ("Daffy","Duck", "daffy@test.com");
		studentDAO.save(tempStudent);
		int theId = tempStudent.getId();
		System.out.println("readStudent()");
		System.out.println("Found student id: " + theId);
		Student theStudent = studentDAO.findId(theId);

		System.out.println("Found student: " + theStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("createMultipleStudents()");
		Student tempStudent1 = new Student(
				"Loic",
				"x",
				"loic@luv2code.com"
		);

		Student tempStudent2 = new Student(
				"Alex",
				"z",
				"alex@luv2code.com"
		);

		Student tempStudent3 = new Student(
				"Suyan",
				"Tian",
				"suyan@luv2code.com"
		);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("createStudent()");
		Student tempStudent = new Student(
				"Joe",
				"Bo",
				"joe@luv2code.com"
		);

		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		System.out.println("Saved the student. Generated id:" + tempStudent.getId());
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {
		theAccountDAO.addAccount();
	}
}
