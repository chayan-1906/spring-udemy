package com.pdas.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pdas.hibernate.demo.entity.Course;
import com.pdas.hibernate.demo.entity.Instructor;
import com.pdas.hibernate.demo.entity.InstructorDetail;
import com.pdas.hibernate.demo.entity.Review;
import com.pdas.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
		                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
		                .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
		                .addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course course = new Course("Pacman - How to score one million points");
			
			// save the course
			System.out.println("\nSaving the course...");
			System.out.println(course);
			session.save(course);
			System.out.println("Saved the course: " + course);
			
			// create the students
			Student student1 = new Student("Padmanabha", "Das", "padmanabhadas9647@gmail.com");
			Student student2 = new Student("Prosenjit", "Das", "prasenjitdaslalbagh@gmail.com");
			
			// add students to the course
			course.addStudent(student1);
			course.addStudent(student2);
			
			// save the students
			System.out.println("\nSaving students...");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved students: " + course.getStudents());
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}
}
