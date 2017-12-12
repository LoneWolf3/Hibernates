package com.sac.mapping;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idemployee;

	@ElementCollection
	@CollectionTable(name = "employee_courses", joinColumns = @JoinColumn(name = "idemployee"))
	private Set<Course> courses = new HashSet<Course>();
	@Embedded
	private Address employeeAddress;
	private String name;

	public Employee(String name, Address employeeAddress, Set<Course> courses2) {
		this.name = name;
		this.employeeAddress = employeeAddress;
		this.courses = courses2;
	}

	public Set<Course> getCourse() {
		return courses;
	}

	public void setCourse(Set<Course> courses) {
		this.courses = courses;
	}

	public Address getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(Address employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public int getIdemployee() {
		return idemployee;
	}

	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}