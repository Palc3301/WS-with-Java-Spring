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

import com.example.ActivityWSFacisa.model.User;
import com.example.ActivityWSFacisa.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public ResponseEntity<List <User> > listAllUsers(){
		return new ResponseEntity<List<User>>
		(userService.listAllUsers(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable int id) {
		User user = userService.getById(id);
		return user;
	}
	
}
	/*@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {
		userService.save(user);
		return ResponseEntity<String>(HttpStatus.CREATED);
	}*/
