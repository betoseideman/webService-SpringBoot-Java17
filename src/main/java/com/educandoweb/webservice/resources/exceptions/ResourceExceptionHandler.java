package com.educandoweb.webservice.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.webservice.services.exceptions.DatabaseException;
import com.educandoweb.webservice.services.exceptions.ResourceNotFoundException;

@ControllerAdvice			// ESSA @ INTERCEPTA OS ERROS
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class) //@ QUE INTERCEPTA QUALQUER ERRO DA CLASSE.class
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resouce not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class) //@ QUE INTERCEPTA QUALQUER ERRO DA CLASSE.class
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		String error = "Data base error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}