package com.companyabc.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Position {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String name;
	@OneToMany
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	

}
