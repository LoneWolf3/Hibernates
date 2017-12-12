package com.sac.association;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone_number")
public class PhoneNumber1toManyBiJT {

	private long id;
	private String number;
	@ManyToOne(optional = false)
	private Employee1toManyBiJT emp;

	public Employee1toManyBiJT getEmp() {
		return emp;
	}

	public void setEmp(Employee1toManyBiJT emp) {
		this.emp = emp;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PhoneNumber1toManyBiJT(String number) {

		this.number = number;
	}

	public PhoneNumber1toManyBiJT() {
	}

	@Id
	@GeneratedValue
	@Column(name = "Phone_Id")
	public long getId() {
		return id;
	}

}