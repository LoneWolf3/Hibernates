package com.sac.mapping;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.SessionManager;

public class Main {

	public static void main(String[] args) {
		saveEmployee();
	}

	public static void saveEmployee() {
		Session session = SessionManager.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			BooleanUserType obj = new BooleanUserType();
			obj.setFalseIndicator(false);
			obj.setTrueIndicator(true);
			session.save(obj);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}