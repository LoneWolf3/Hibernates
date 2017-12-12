package com.sac.association;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_1toManyJC")
public class Employee1toManyUniJC {
	@Id
	@GeneratedValue
	private long Id;

	private String empName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private Set<PhoneNumber1toManyBiJT> number;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Set<PhoneNumber1toManyBiJT> getNumber() {
		return number;
	}

	public void setNumber(Set<PhoneNumber1toManyBiJT> number) {
		this.number = number;
	}

	public Employee1toManyUniJC() {
	}

	public Employee1toManyUniJC(String empName, Set<PhoneNumber1toManyBiJT> numb) {
		this.empName = empName;
		this.number = numb;

	}

	@Column(name = "emp_name", nullable = false, length = 100)
	public String getempName() {
		return this.empName;
	}

	public void setempName(String empName) {
		this.empName = empName;
	}

}