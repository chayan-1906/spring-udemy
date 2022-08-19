package com.pdas.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pdas.hibernate.demo.entity.Instructor;
import com.pdas.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
		                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
		                .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// get instructor by primary key / id
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);
			System.out.println("Found Instructor: " + instructor);
			
			// delete the instructors
			if (instructor != null) {
				System.out.println("Deleting: " + instructor);
				/*
				 * NOTE: will also delete associated "details" object
				 */
				session.delete(instructor);
			}
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
