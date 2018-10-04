package com.darraghblake.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.darraghblake.hibernate.practice.entity.Instructor;
import com.darraghblake.hibernate.practice.entity.InstructorDetail;


public class DeleteDemo {

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
			// start a transaction
			session.beginTransaction();
			
			// get instructor by primary key / id
			// an example key
			//
			int theId = 23;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found instructor: " + tempInstructor);
			
			// delete the instructor
			if (tempInstructor != null) {
				System.out.println("Deleting: " + tempInstructor);
				
				// Note: will also delete associated "details" object
				// because of CascadeType.ALL
				//
				session.delete(tempInstructor);
			}
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done.");
		}
		finally {
			factory.close();
		}
		
	}

}
