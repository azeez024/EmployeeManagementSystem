package com.emp.exceptions;

public class EmployeeDataNotExists extends RuntimeException{
	public EmployeeDataNotExists(String message) {
		super(message);
	}

}
