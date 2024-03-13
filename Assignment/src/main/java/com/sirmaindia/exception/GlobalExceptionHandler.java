package com.sirmaindia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DateMismatchException.class)
	public ResponseEntity<String> handleDateException(DateMismatchException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
	}
	@ExceptionHandler(ProjectIdNotFoundException.class)
	public ResponseEntity<String> handleProjectIdException(ProjectIdNotFoundException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(invalidIdException.class)
	public ResponseEntity<String> handleInvalidIdException(invalidIdException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProjectAlreadyExistsException.class)
	public ResponseEntity<String> handleDataAlreadyPresentException(ProjectAlreadyExistsException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.ALREADY_REPORTED);
	}
}
