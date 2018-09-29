package com.sistnet.projeto.services.exeptions;

public class AuthorizationExeption extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AuthorizationExeption(String msg) {
		super(msg);
	}

	public AuthorizationExeption(String msg, Throwable cause) {
		super(msg, cause);
	}
}
