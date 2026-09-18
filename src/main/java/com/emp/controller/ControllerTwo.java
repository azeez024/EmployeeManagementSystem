package com.emp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.dto.EmployeeResponse;

@RestController
public class ControllerTwo {

	@GetMapping
	public EmployeeResponse call() {
		return null;
	}
}
