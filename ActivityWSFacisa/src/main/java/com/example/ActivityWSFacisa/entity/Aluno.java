package com.example.ActivityWSFacisa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Aluno {
	
	@Id
	private int rdm;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 30)
	private String course;

	public int getRdm() {
		return rdm;
	}

	public void setRdm(int rdm) {
		this.rdm = rdm;
	}

	public Aluno() {
		super();
	}

	public Aluno(int rdm, String name, String course) {
		super();
		this.rdm = rdm;
		this.name = name;
		this.course = course;
	}
	
}
