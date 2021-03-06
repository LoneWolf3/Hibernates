package com.sac.mapping;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String street;
public Address() {}

	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	private String city;
	private String state;
	@Column(name = "ZIP_CODE")
	private String zip;

	public String getStreet() {
		return street;
	}

	public void setStreet(String address) {
		this.street = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String toString() {
		return "Address street: " + getStreet() + ", city: " + getCity() + ", state: " + getState() + ", zip: "
				+ getZip();
	}

}