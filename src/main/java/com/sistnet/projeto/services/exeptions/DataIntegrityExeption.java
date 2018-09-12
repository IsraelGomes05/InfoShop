package com.sistnet.projeto.services.exeptions;

public class DataIntegrityExeption extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataIntegrityExeption(String msg) {
		super(msg);
	}

	public DataIntegrityExeption(String msg, Throwable cause) {
		super(msg, cause);
	}
}
