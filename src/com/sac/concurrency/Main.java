package com.sac.concurrency;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.SessionManager;

public class Main {
	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {

				Session session = SessionManager.getSessionFactory().openSession();
				Transaction tx2 = session.beginTransaction();
				Product stock = (Product)session.get(Product.class, 1);
				stock.setDescription("LLLLLLL");
				session.update(stock);
				tx2.commit();
				System.out.println("Object saved successfully.....!!");
				;
			}

		}).start();;
		Session session = SessionManager.getSessionFactory().openSession();
		Product p = new Product();

		p.setPrice(new BigDecimal("11"));
		p.setDescription("AC");

		Transaction tx = session.beginTransaction();
		session.save(p);
		System.out.println("Object saved successfully.....!!");
		tx.commit();
		Transaction tx2 = session.beginTransaction();
		Product stock = (Product)session.get(Product.class, 1);
		stock.setDescription("ZZ");
		session.update(stock);
		System.out.println("Object saved successfully.....!!");
		tx2.commit();
		session.close();

	}
}
