package com.sac.collection;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id")
	@MapKey(name = "id")
	private Map<Integer, State> states;

	public Country(int id, String name, Map<Integer, State> states) {
		this.id = id;
		this.name = name;
		this.states = states;
	}

	public Country() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer, State> getStates() {
		return states;
	}

	public void setStates(Map<Integer, State> states) {
		this.states = states;
	}
}