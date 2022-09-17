package com.example.ActivityWSFacisa.excepetions;

public class UserAlreadyExistsException extends Exception {
	
	public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
