package com.pdas.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pdas.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").list();
			displayStudents(theStudents);
			
			// query students: lastName = "Das"
			theStudents = session.createQuery("from Student s where s.lastName='Das'").list();
			System.out.println("\n\nStudents with lastname 'Das': ");
			displayStudents(theStudents);
			
			// query students: lastName='Das' OR firstName='Padmanabha'
			theStudents = session.createQuery("from Student s where s.lastName='Das' OR s.firstName='Padmanabha'").list();
			System.out.println("\n\nStudents with lastname 'Das' OR firstName 'Padmanabha': ");
			displayStudents(theStudents);
			
			// query students where email LIKE '%gmail.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
			System.out.println("\n\nStudents with email 'gmail.com': ");
			displayStudents(theStudents);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student student : theStudents) {
			System.out.println(student);
		}
	}
}
