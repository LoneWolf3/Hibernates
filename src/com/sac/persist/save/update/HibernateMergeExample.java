package com.sac.persist.save.update;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.SessionManager;

public class HibernateMergeExample {

	public static void main(String[] args) {

		// Prep Work
		SessionFactory sessionFactory = SessionManager.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee emp = (Employee) session.load(Employee.class, new Long(101));
		System.out.println("Employee object loaded. " + emp);
		tx.commit();

		 //merge example - data already present in tables
		 emp.setSalary(25000);
		 Transaction tx8 = session.beginTransaction();
		 Employee emp4 = (Employee) session.merge(emp);
		 System.out.println(emp4 == emp); // returns false
		 emp.setName("Test");
		 emp4.setName("Kumar");
		 System.out.println("15. Before committing merge transaction");
		 tx8.commit();
		 System.out.println("16. After committing merge transaction");

		// Close resources
		sessionFactory.close();

	}

}