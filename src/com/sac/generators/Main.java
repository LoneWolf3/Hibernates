package com.sac.generators;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.SessionManager;

public class Main {

	public static void main(String[] args) {
		System.err.println(" =======SAVE =======");
		for (int i = 0; i < 8; i++) {
			hiLo("a" + i);
		}

	}

	public static Integer assignedGenerator(String name, int id) {
		Session session = SessionManager.getSessionFactory().openSession();
		Transaction transaction = null;
		Integer courseId = null;

		try {
			transaction = session.beginTransaction();
			EmployeeAssigned em1 = new EmployeeAssigned();
			em1.setId(id);
			em1.setName(name);
			courseId = (Integer) session.save(em1);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return courseId;
	}

	public static Integer increment(String name) {
		Session session = SessionManager.getSessionFactory().openSession();
		Transaction transaction = null;
		Integer courseId = null;

		try {
			transaction = session.beginTransaction();
			EmployeeIncrement em1 = new EmployeeIncrement();
			em1.setName(name);
			courseId = (Integer) session.save(em1);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return courseId;
	}

	public static Integer identity(String name) {
		Session session = SessionManager.getSessionFactory().openSession();
		Transaction transaction = null;
		Integer courseId = null;

		try {
			transaction = session.beginTransaction();
			EmployeeIdentity em1 = new EmployeeIdentity();
			em1.setName(name);
			courseId = (Integer) session.save(em1);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return courseId;
	}

	public static Integer hiLo(String name) {
		Session session = SessionManager.getSessionFactory().openSession();
		Transaction transaction = null;
		Integer courseId = null;

		try {
			transaction = session.beginTransaction();
			EmployeeHiLo em1 = new EmployeeHiLo();
			em1.setName(name);
			courseId = (Integer) session.save(em1);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return courseId;
	}
}
