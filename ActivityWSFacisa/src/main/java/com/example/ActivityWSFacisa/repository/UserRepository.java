package com.example.ActivityWSFacisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.ActivityWSFacisa.entity.User;

@RepositoryRestResource(collectionResourceRel = "user", path = "user" )
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findById(int id);
	public User findByName(String name);
}
