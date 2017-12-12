package com.sac.basic.crud;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.SessionManager;

public class Main {

	public static void main(String[] args) {
		System.err.println(" =======SAVE =======");
		saveEmployee("a");
		saveEmployee("b");
		/*System.err.println(" =======READ =======");
		List<Employee> ems1 = read();
		for (Employee e : ems1) {
			System.err.println(e.toString());
		}

		System.err.println(" =======UPDATE =======");
		update(1);
		List<Employee> ems2 = read();
		for (Employee e : ems2) {
			System.err.println(e.toString());
		}
		System.err.println(" =======DELETE ======= ");
		delete(1);
		List<Employee> ems3 = read();
		for (Employee e : ems3) {
			System.err.println(e.toString());
		}
		System.err.println(" =======DELETE ALL ======= ");
		deleteAll();
		List<Employee> ems4 = read();
		for (Employee e : ems4) {
			System.err.println(e.toString());
		}*/

		System.exit(0);
	}

	public static Integer saveEmployee(String name) {
		Session session = SessionManager.getSessionFactory().openSession();
		Transaction transaction = null;
		Integer courseId = null;
		try {
			transaction = session.beginTransaction();
			Employee em1 = new Employee();
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

	public static List<Employee> read() {
		Session session = SessionManager.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Employee> employees = session.createQuery("FROM Employee").list();
		session.close();
		System.err.println("Found " + employees.size() + " Employees");
		return employees;

	}

	public static void update(Integer id) {
		Session session = SessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		Employee em = (Employee) session.load(Employee.class, id);
		em.setName("c");
		session.getTransaction().commit();
		session.close();
		System.err.println("Successfully updated ");

	}

	public static void delete(Integer id) {
		Session session = SessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		Employee e = findByID(id);
		session.delete(e);
		session.getTransaction().commit();
		session.close();
		System.err.println("Successfully deleted " + e.toString());

	}

	public static Employee findByID(Integer id) {
		Session session = SessionManager.getSessionFactory().openSession();
		Employee e = (Employee) session.load(Employee.class, id);
		session.close();
		return e;
	}

	public static void deleteAll() {
		Session session = SessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM Employee ");
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		System.err.println("Successfully deleted all employees.");

	}
}
