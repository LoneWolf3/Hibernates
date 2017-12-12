package com.sac.cache;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import com.util.SessionManager;
 
 
public class MainApp
{
	private static SessionFactory sf = null;
	private static Statistics stats = null;
	private static Session session1 = null;
	private static Session session2 = null;
	
	private static Transaction tx1 = null;
	
   public static void main(String[] args)
   {
	  sf = SessionManager.getSessionFactory();
	  session1 = sf.openSession();
	  session2 = sf.openSession();;
	  
	  tx1 = session1.beginTransaction();
	  stats = sf.getStatistics();
	  stats.setStatisticsEnabled(true);
      insertRecord();
      tx1.commit();
      
      loadRecords();
      
      sf.close();
   }

	private static void insertRecord() {
		
		// Add new Employee object
	    EmployeeCache emp = new EmployeeCache(1, "Ashish", "Mondal", "ashismo@gmail.com");
	    session1.save(emp);
	    
	   // Add another Employee object
	    emp = new EmployeeCache(2, "Ujan", "Mondal", "ujanmo@gmail.com");
	    session1.save(emp);
	}
	
	private static void loadRecords() {
		printStats("We haven't hit the database so hit=0, miss=0 \n"
				+ "and put=2 because 2 Employee data \n"
				+ "got saved via this session factory");
		
        EmployeeCache emp = (EmployeeCache) session1.load(EmployeeCache.class, 1);
        printRecord(emp, "EmployeeId=1 data is available in session1 so \n"
        		+ "the hit, miss and put count remains same");
        
        emp = (EmployeeCache) session2.load(EmployeeCache.class, 1);
        printRecord(emp,  "EmployeeId=1 data is not available in level 1 cache for session2 so \n"
        		+ "the hit, miss and put count remains same");
         
        try {
        	System.out.println("**** Thread is going to sleep for 2 sec so Employee data will get removed from 2nd level cache. \n "
        			+ "Next time it is going to hit database****");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
        emp = (EmployeeCache) session2.load(EmployeeCache.class, 2);
        printRecord(emp, "EmployeeId=2 data is not available in level 1 and level 2 cache for session2 so \n"
        		+ "the fetch=1, hit=1, miss=1 and put=3");
        
        emp = (EmployeeCache) session2.get(EmployeeCache.class, 3); // This data is not available in database
        printRecord(emp, "EmployeeId=3 data is not available in DB so \n"
        		+ "the fetch=1, hit=1, miss=2 and put=3");
	}
	
	private static void printStats(String msg) {
		if(msg != null) {
			System.out.println("=========\n" + msg + "\n===========");
		}
		System.out.println("Fetch Count=" + stats.getEntityFetchCount());
		System.out.println("Second Level Hit Count= " + stats.getSecondLevelCacheHitCount());
		System.out.println("Second Level Miss Count=" + stats.getSecondLevelCacheMissCount());
		System.out.println("Second Level Put Count=" + stats.getSecondLevelCachePutCount());
		System.out.println("---------------------------\n\n");
	}
	private static void printRecord(EmployeeCache emp, String msg) {
		System.out.println("=========\n" + msg);
		if(emp != null) {
			System.out.println("Data from database - EmpId: " + emp.getEmployeeId() + " Name: " + emp.getFirstName() + " " + emp.getLastName() + " Email: " + emp.getEmail());
		}
		System.out.println("==========");
		printStats(null);
	}
}