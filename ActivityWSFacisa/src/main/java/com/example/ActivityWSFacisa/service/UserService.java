package com.example.ActivityWSFacisa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.ActivityWSFacisa.entity.User;
import com.example.ActivityWSFacisa.excepetions.UserAlreadyExistsException;
import com.example.ActivityWSFacisa.repository.UserRepository;

@Service
@Validated
public class UserService {

	@Autowired
	private UserRepository repository;

	
	public User getById(int id) {
		return repository.findById(id);
	}

	public List<User> listAllUsers() {
		return (List<User>) repository.findAll();
	}

	public User save(User user) throws UserAlreadyExistsException {

		User exist = repository.findByName(user.getName());

		if (exist != null) {
			throw new UserAlreadyExistsException();
		}
		return repository.save(user);
	}

}
