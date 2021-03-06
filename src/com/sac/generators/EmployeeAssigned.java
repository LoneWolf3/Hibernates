package com.sac.generators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeAssigned")
public class EmployeeAssigned {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	public EmployeeAssigned() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee: " + this.id + ", " + this.name ;
	}

}
