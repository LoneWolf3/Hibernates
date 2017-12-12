package com.sac.inheritance;

import java.util.List;

import org.hibernate.Session;

import com.util.SessionManager;

public class Main {
	public static void main(String[] args) {

		exectueQuery("delete from com.sac.inheritance.PaymentCardImplicitPoly");
		exectueQuery("delete from com.sac.inheritance.PaymentCashImplicitPoly");
		saveEntities(new PaymentCardImplicitPoly(600L, "IND", "123456789", "Salil Verma"));
		saveEntities(new PaymentCashImplicitPoly(200L, "USD", "Salil Verma"));
		System.out.println("\n\nList of Payments = " + getRecordsOfType(PaymentImplicitPoly.class));

	}

	public static int exectueQuery(final String hqlQuery) {
		int effectedRecords = 0;
		final Session session = SessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			effectedRecords = session.createQuery(hqlQuery).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return effectedRecords;
	}

	public static void saveEntities(final Object entity) {
		final Session session = SessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<PaymentImplicitPoly> getRecordsOfType(final Class<PaymentImplicitPoly> classObject) {
		final Session session = SessionManager.getSessionFactory().openSession();
		List<PaymentImplicitPoly> l ;
		try {
			l = (List<PaymentImplicitPoly>) session.createCriteria(classObject).list();
		} finally {
			session.close();
		}
		return l;
	}
}
