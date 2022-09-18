package com.example.ActivityWSFacisa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String usuario;

	private String password;

}
