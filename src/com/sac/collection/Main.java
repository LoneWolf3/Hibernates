package com.sac.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import com.util.SessionManager;

public class Main {
	public static void main(String[] args) {
		
	}

	public static void collectionExample() {
		Session session = SessionManager.openSession();
		session.beginTransaction();

		College c = new College(1, "S.S.P.C");
		session.persist(c);
		Student s1 = new Student(1, "Atul", 1);
		session.persist(s1);
		Student s2 = new Student(2, "Saurabh", 1);
		session.persist(s2);

		session.getTransaction().commit();
		session.refresh(c);
		College ob = (College) session.get(College.class, new Integer(1));
		Set<String> names = ob.getStudents();
		for (String s : names) {
			System.out.println(s);
		}

	}
	
	public static void mapExample() {
		Session session=SessionManager.openSession();
    	session.beginTransaction();
    	Country c=(Country)session.get(Country.class, new Integer(1));
    	Map<Integer,State> states = c.getStates();
    	Iterator entries = states.entrySet().iterator();
    	while (entries.hasNext()) {
    	    Map.Entry entry = (Map.Entry) entries.next();
    	    Integer key = (Integer)entry.getKey();
    	    State value = (State)entry.getValue();
    	    System.out.println("Key = " + key + ", Value = " + value.getName());
    	}
    	session.close();
	}
}
