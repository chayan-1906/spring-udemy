package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// add exception handling code here
	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
		// create a StudentErrorResponse
		StudentErrorResponse studentErrorRepsonse = new StudentErrorResponse();
		studentErrorRepsonse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorRepsonse.setMessage(exception.getMessage());
		studentErrorRepsonse.setTimestamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(studentErrorRepsonse, HttpStatus.NOT_FOUND);
	}

	// add another exception handler... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
		// create a StudentErrorResponse
		StudentErrorResponse studentErrorRepsonse = new StudentErrorResponse();
		studentErrorRepsonse.setStatus(HttpStatus.BAD_REQUEST.value());
		studentErrorRepsonse.setMessage(exception.getMessage());
		studentErrorRepsonse.setTimestamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(studentErrorRepsonse, HttpStatus.BAD_REQUEST);
	}

}
