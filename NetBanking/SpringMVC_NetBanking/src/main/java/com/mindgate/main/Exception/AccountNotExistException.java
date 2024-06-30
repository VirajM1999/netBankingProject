package com.mindgate.main.Exception;

public class AccountNotExistException extends RuntimeException{
	
	private String message;
	
	public AccountNotExistException() {
		// TODO Auto-generated constructor stub
	}

	public AccountNotExistException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
	

}
