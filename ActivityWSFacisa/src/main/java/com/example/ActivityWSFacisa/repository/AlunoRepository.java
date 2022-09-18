package com.example.ActivityWSFacisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.ActivityWSFacisa.entity.Aluno;

@RepositoryRestResource(collectionResourceRel = "aluno", path = "aluno" )
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	

	public Aluno findByName(String name);
}
