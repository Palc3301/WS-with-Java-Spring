package com.example.ActivityWSFacisa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.ActivityWSFacisa.model.User;

@RepositoryRestResource(collectionResourceRel = "user", path = "user" )
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
	
	public User findById(int id);
	public User findByName(String name);
}
