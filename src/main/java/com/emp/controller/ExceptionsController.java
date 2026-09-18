package com.emp.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.emp.exceptions.EmployeeDataNotExists;

@ControllerAdvice
public class ExceptionsController {

	@ExceptionHandler(EmployeeDataNotExists.class)
	public ResponseEntity<?> handlingEmployeeDataNotExists(EmployeeDataNotExists employeeException){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("header1", "erroroccured");
		return new ResponseEntity<String>(String.valueOf(employeeException.getMessage()), httpHeaders,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlingMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
		
		List<FieldError> fieldErrors = methodArgumentNotValidException.getFieldErrors();
		
		return new ResponseEntity<>(fieldErrors.get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
	}
}
