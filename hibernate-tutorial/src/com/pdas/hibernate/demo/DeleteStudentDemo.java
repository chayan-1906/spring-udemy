package com.pdas.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pdas.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// delete the student
			/*System.out.println("Deleting student " + myStudent + "...");
			session.delete(myStudent);
			System.out.println("Student deleted!");*/
			
			// delete student with id = 2
			System.out.println("Deleting student of id = 2...");
			session.createQuery("delete from Student where id=2").executeUpdate();
			System.out.println("Student with id=2 deleted!");
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
