package com.sai.lib.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptions {
	 @ExceptionHandler(value= NoSuchElementException.class)
     public ResponseEntity<?> userNotFoundException(){
    	 return new ResponseEntity<>("There is no data matching your input",HttpStatus.NOT_FOUND);
     }
	 @ExceptionHandler(value=SQLIntegrityConstraintViolationException.class)
	 public ResponseEntity<?> dataItigrity(){
		 return new ResponseEntity<>("given genresid not available in genre table",HttpStatus.BAD_REQUEST);
	 }
}
