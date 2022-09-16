package com.example.ActivityWSFacisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ActivityWSFacisa.model.User;

@Service
public interface UserService {
	
	User save(User user) throws Exception;
	
	User getById(int id);
	
	List<User> listAllUsers();

	
}
