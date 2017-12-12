package com.sac.association;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_manyto1")
public class EmployeeManyto1 {
	@Id
	@GeneratedValue
	@Column(name = "emp_ID")
	private long empId;
	@Column(name = "emp_NAME", nullable = false, length = 100)
	private String empName;
	@ManyToOne(fetch=FetchType.EAGER)
	private Address empAddress;

	public EmployeeManyto1() {
	}

	public EmployeeManyto1(String empName, Address empAddress) {
		this.empName = empName;
		this.empAddress = empAddress;	
	}


	public long getempId() {
		return this.empId;
	}

	public void setempId(long empId) {
		this.empId = empId;
	}

	public String getempName() {
		return this.empName;
	}

	public void setempName(String empName) {
		this.empName = empName;
	}

	
	public Address getempAddress() {
		return this.empAddress;
	}

	public void setempAddress(Address empAddress) {
		this.empAddress = empAddress;
	}
}