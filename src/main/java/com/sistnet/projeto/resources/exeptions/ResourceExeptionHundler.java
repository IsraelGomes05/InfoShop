package com.sistnet.projeto.resources.exeptions;

import javax.servlet.http.HttpServletRequest;

import com.sistnet.projeto.services.exeptions.DataIntegrityExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sistnet.projeto.services.exeptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExeptionHundler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		StandarError error = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityExeption.class)
	public ResponseEntity<StandarError> dataEntregity(DataIntegrityExeption e, HttpServletRequest request){
		StandarError error = new StandarError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
