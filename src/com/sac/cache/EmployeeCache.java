package com.sac.cache;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
 
@Entity
@Table(name = "Employee_Cache", uniqueConstraints = {@UniqueConstraint(columnNames = "ID"), @UniqueConstraint(columnNames = "EMAIL")})
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="com.sac.cache.EmployeeCache")
public class EmployeeCache implements Serializable
{
   private static final long serialVersionUID = -1798070786993154676L;
   @Id
   @Column(name = "ID", unique = true, nullable = false)
   private Integer           employeeId;
   @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
   private String            email;
   @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
   private String            firstName;
   @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
   private String            lastName;
 
   public EmployeeCache() {}
   
   public EmployeeCache(int employeeId, String firstName, String lastName, String email) {
	   this.employeeId = employeeId;
	   this.firstName = firstName;
	   this.lastName = lastName;
	   this.email = email;
   }
   public Integer getEmployeeId()
   {
      return employeeId;
   }
 
   public void setEmployeeId(Integer employeeId)
   {
      this.employeeId = employeeId;
   }
 
   public String getEmail()
   {
      return email;
   }
 
   public void setEmail(String email)
   {
      this.email = email;
   }
 
   public String getFirstName()
   {
      return firstName;
   }
 
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }
 
   public String getLastName()
   {
      return lastName;
   }
 
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }
}