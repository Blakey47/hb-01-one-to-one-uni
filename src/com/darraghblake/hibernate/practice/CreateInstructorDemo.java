package com.darraghblake.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.darraghblake.hibernate.practice.entity.Instructor;
import com.darraghblake.hibernate.practice.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// create session factory
		System.out.println("\nCreating factory..." + 
							"\n\n");
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		// create session
		System.out.println("\nCreating session..." + 
							"\n\n");
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			Instructor tempInstructor = new Instructor("Sarah", "Jane", "janesarah@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.sarahjanecodingschool.com", "Coding");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ASLO save the details object
			// because of CascaseType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done.");
		}
		finally {
			factory.close();
		}
		
	}

}
