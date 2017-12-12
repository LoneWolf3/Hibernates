package com.sac.association;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.SessionManager;

public class Main {

	public static void main(String[] args) {
		sharePrimaryKey();
	}

	public static void manyto1() {
		Session session = SessionManager.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address = new Address("A");
			session.persist(address);
			EmployeeManyto1 student1 = new EmployeeManyto1("Eswar", address);
			EmployeeManyto1 student2 = new EmployeeManyto1("Joe", address);
			session.save(student1);
			session.save(student2);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public static void manyto1LazyFetch() {

		Session session = SessionManager.openSession();
		Transaction tx = session.beginTransaction();
		EmployeeManyto1 lazy = (EmployeeManyto1) session.byId(EmployeeManyto1.class).load(new Long(1));
		tx.commit();
		session.close();
		System.out.println(lazy.getempAddress().getStreet());

	}

	public static void oneToMany() {
		Session session = SessionManager.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			PhoneNumber1toManyBiJT student1 = new PhoneNumber1toManyBiJT("111");
			PhoneNumber1toManyBiJT student2 = new PhoneNumber1toManyBiJT("222");
			Set<PhoneNumber1toManyBiJT> s = new HashSet<PhoneNumber1toManyBiJT>();
			s.add(student1);
			s.add(student2);
			Employee1toManyBiJT obj = new Employee1toManyBiJT("abc", s);
			session.save(obj);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public static void sharePrimaryKey() {

	}

	public static void OneToOneforignKey() {
		Session session = SessionManager.openSession();
		session.beginTransaction();

		Account1to1FK account = new Account1to1FK();
		account.setAccountNumber("123-345-65454");

		// Add new Employee object
		Employee1to1FK emp = new Employee1to1FK();
		emp.setFirstName("demo");

		// Save Account
		session.saveOrUpdate(account);
		// Save Employee
		emp.setAccount(account);
		session.saveOrUpdate(emp);

		session.getTransaction().commit();
		session.close();
	}

	public static void OneToOneJoinTable() {
		Session session = SessionManager.openSession();
		session.beginTransaction();

		Account1to1JT account = new Account1to1JT();
		account.setAccountNumber("123-345-65454");

		// Add new Employee object
		Employee1to1JT emp = new Employee1to1JT();
		emp.setFirstName("demo");

		emp.setAccount(account);
		// Save Employee
		session.save(emp);

		session.getTransaction().commit();
		session.close();
	}

	public static void OneToOneSharedPrimaryKey() {
		Session session = SessionManager.openSession();
		session.beginTransaction();
		Account1to1SharedPK account = new Account1to1SharedPK();
		account.setAccountNumber("123-345-65454");
		Employee1to1SharedPK emp = new Employee1to1SharedPK();
		emp.setFirstName("demo");
		emp.setAccount(account);
		account.setEmployee(emp);
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	}

	public void bidirectionalOneToMany() {
		Session session = SessionManager.openSession();
		Transaction tx = session.beginTransaction();
		Employee1toManyBiJT emp = new Employee1toManyBiJT();
		emp.setempName("First title");
		PhoneNumber1toManyBiJT phone = new PhoneNumber1toManyBiJT();
		phone.setNumber("11111");
		phone.setEmp(emp);
		emp.getNumber().add(phone);
		session.save(emp);
		tx.commit();
		session.close();

	}

	public void biDirectionalfindPhone() {
		Session session = SessionManager.openSession();
		Transaction tx = session.beginTransaction();
		session = SessionManager.openSession();
		tx = session.beginTransaction();
		PhoneNumber1toManyBiJT obj = (PhoneNumber1toManyBiJT) session.byId(PhoneNumber1toManyBiJT.class)
				.load(new Long(1));
		// if we need the book, we have it!
		Employee1toManyBiJT emp2 = obj.getEmp();
		System.out.println(emp2.getNumber());
		tx.commit();
		session.close();
	}

}
