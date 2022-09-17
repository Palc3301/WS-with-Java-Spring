package com.example.ActivityWSFacisa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data @Entity
public class User {
	
	@Id @GeneratedValue
	private int id ;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 25)
	private String usuario;
	
	@Column(length = 25)
	private String password;
	
	public User() {
	}
	
	public User(int id, String name, String usuario, String password) {
		this.id = id;
		this.name = name;
		this.usuario = usuario;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
