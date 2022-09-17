package com.example.ActivityWSFacisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.ActivityWSFacisa.entity.Aluno;
import com.example.ActivityWSFacisa.entity.User;

@RepositoryRestResource(collectionResourceRel = "user", path = "user" )
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	

	public User findByName(String name);
}
