package com.sac.compositekey;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.SessionManager;

public class Main {
	public static void main(String[] args) {
		Session session = SessionManager.getSessionFactory().openSession();
		Transaction transaction = null;
		Integer courseId = null;

		try {
			transaction = session.beginTransaction();
			EmployeeId p= new EmployeeId("1", "99");
			Employee s= new Employee(p, "varanasi");
			 session.save(s);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}
}
