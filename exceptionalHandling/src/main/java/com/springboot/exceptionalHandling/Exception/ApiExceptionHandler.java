package com.springboot.exceptionalHandling.Exception;



import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ApiRequestException.class)
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {

		ApiException exception=new ApiException(e.getLocalizedMessage(), new Date());

		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleException(NoSuchElementException e){
		ApiException exception=new ApiException(e.getLocalizedMessage(), new Date());

		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> methodNotException(HttpRequestMethodNotSupportedException e){
		
		ApiException exception=new ApiException(e.getLocalizedMessage(), new Date());

		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> methodNotException(EmptyResultDataAccessException e){
		
		ApiException exception=new ApiException(e.getLocalizedMessage(), new Date());

		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}
}
