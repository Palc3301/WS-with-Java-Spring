package com.example.ActivityWSFacisa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "Aluno")
public class Aluno {

	// Id desta classe ressalva o Rdm;
	@Id
	private int rdm;

	private String name;

	private String course;

}
