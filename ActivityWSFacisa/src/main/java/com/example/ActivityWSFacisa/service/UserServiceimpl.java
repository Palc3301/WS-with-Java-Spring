package com.example.ActivityWSFacisa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.ActivityWSFacisa.model.User;
import com.example.ActivityWSFacisa.repository.UserRepository;

@Service
@Validated
public class UserServiceimpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public User save(User user) throws Exception {
		
		User exist = repository.findByName(user.getName());
		
		if (exist != null) {
			throw new Exception("User Already Exists");
		}
		return repository.save(user);
	}

	@Override
	public User getById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<User> listAllUsers() {
		return (List<User>) repository.findAll();
	}
}
