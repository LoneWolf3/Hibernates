package com.sac.collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
		
	public State(int id,int countryId,String name){
		this.id=id;
		this.name=name;
	}
	public State(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
 