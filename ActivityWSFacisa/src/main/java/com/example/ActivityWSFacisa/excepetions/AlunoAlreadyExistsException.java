package com.example.ActivityWSFacisa.excepetions;

public class AlunoAlreadyExistsException extends Exception {
	
	public AlunoAlreadyExistsException() {
    }

    public AlunoAlreadyExistsException(String message) {
        super(message);
    }
}
