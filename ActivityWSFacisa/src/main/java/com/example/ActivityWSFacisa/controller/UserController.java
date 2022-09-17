package com.example.ActivityWSFacisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ActivityWSFacisa.entity.User;
import com.example.ActivityWSFacisa.repository.UserRepository;
import com.example.ActivityWSFacisa.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		return new ResponseEntity<List<User>>(userService.listAllUsers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable int id) {
		User user = userService.getById(id);
		return user;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {
		
		try {
			userService.save(user);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
