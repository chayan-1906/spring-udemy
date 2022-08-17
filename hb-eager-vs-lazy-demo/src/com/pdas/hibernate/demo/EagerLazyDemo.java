package com.pdas.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pdas.hibernate.demo.entity.Course;
import com.pdas.hibernate.demo.entity.Instructor;
import com.pdas.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
		                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
		                .addAnnotatedClass(Course.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor: " + instructor);
			
			// get course for the instructor
			System.out.println("Courses: " + instructor.getCourses());
			
			System.out.println("pdas Courses: " + instructor.getCourses());
			
			// commit the transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			System.out.println("\nThe session is now closed\n");
			
			// since courses are lazy loaded... this should fail
			
			// get courses for the instructor
			System.out.println("pdas Courses: " + instructor.getCourses());
			
			System.out.println("Done");
		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}
}
