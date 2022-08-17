package com.pdas.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pdas.hibernate.demo.entity.Instructor;
import com.pdas.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
		                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
		                .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			/*
			 * Instructor tempInstructor = new Instructor("Padmanabha", "Das",
			 * "padmanabhadas9647@gmail.com"); InstructorDetail tempInstructorDetail = new
			 * InstructorDetail(
			 * "https://studio.youtube.com/channel/UCbuhjYDMON-hE4uGD1BAMSQ", "Coding");
			 */
			
			Instructor tempInstructor = new Instructor("Prosenjit", "Das", "prasenjitdaslalbagh@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://studio.youtube.com",
			                "Teaching");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			/*
			 * NOTE: this will also save the details object because of CascadeType.All
			 */
			System.out.println("Saving instructor: " + tempInstructor + "...");
			session.save(tempInstructor);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
