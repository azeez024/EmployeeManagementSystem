package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.dto.EmployeeRequest;
import com.emp.dto.EmployeeResponse;
import com.emp.entity.EmployeeEntity;
import com.emp.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired 
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeResponse> addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
		
		EmployeeResponse employeeResponse = employeeService.addEmployee(employeeRequest);
		
		return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable long id, @RequestHeader String header1){
		
		return  employeeService.getEmployee(id,header1);
		
	}
	@GetMapping
	public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
		List<EmployeeResponse> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable long id) {
		return employeeService.deleteEmployee(id);
	}
	
	@PostMapping("/addall")
	public String addAllEmployees(@RequestBody List<EmployeeRequest> employees){
		return employeeService.addAllEmployees(employees);
	}
	
	@PutMapping
	public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody EmployeeResponse employeeResponse){
		EmployeeResponse employeeResponse2 = employeeService.updateEmployee(employeeResponse);
		return new ResponseEntity<EmployeeResponse>(employeeResponse2, HttpStatus.OK);
	}
	
	@GetMapping("/department/{department}")
	public ResponseEntity<List<EmployeeResponse>> getEmployeesByDepartment(@PathVariable String department){
		List<EmployeeResponse> response = employeeService.getEmployeeByDepartment(department);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/salary/{salary}")
	public ResponseEntity<List<EmployeeResponse>> findBySalaryGreaterThan(@PathVariable int salary){
		List<EmployeeResponse> response = employeeService.findBySalaryGreaterThan(salary);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/phone/{phone}")
	public ResponseEntity<List<EmployeeResponse>> getEmployeeByMobile(@PathVariable String phone) {
		List<EmployeeResponse> employeeResponse = employeeService.getEmployeeByPhone(phone);
		return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<?> getEmployeeByEmail(@PathVariable String email){
		EmployeeResponse employeeResponse = employeeService.getEmployeeByEmail(email);
		if(employeeResponse!=null) return new ResponseEntity<EmployeeResponse>(employeeResponse,HttpStatus.OK);
		else return new ResponseEntity<>("No Employee on this Email",HttpStatus.OK);
	}
	 
	@GetMapping("/firstname/{firstName}")
	public ResponseEntity<?> getEmployeesByFirstName(@PathVariable String firstName){
		List<EmployeeResponse> employeeResponses = employeeService.getEmployeesByFirstName(firstName);
		if(employeeResponses==null || employeeResponses.isEmpty()) return new ResponseEntity<String>("No Employees", HttpStatus.OK);
		else return new ResponseEntity<List<EmployeeResponse>>(employeeResponses,HttpStatus.OK);
		 
	}
	
	@GetMapping("/lastname/{lastName}")
	public ResponseEntity<?> getEmployeesByastName(@PathVariable String lastName){
		List<EmployeeResponse> employeeResponses = employeeService.getEmployeesByLastName(lastName);
		if(employeeResponses==null || employeeResponses.isEmpty()) return new ResponseEntity<String>("No Employees", HttpStatus.OK);
		else return new ResponseEntity<List<EmployeeResponse>>(employeeResponses,HttpStatus.OK);
	}
	
	@GetMapping("/idandfirstname/{id}/{firstName}")
	public ResponseEntity<?> getEmployeeByIdAndFirstName(@PathVariable long id, @PathVariable String firstName){
		EmployeeResponse employeeResponse  = employeeService.getEmployeeByIdAndFirstName(id, firstName);
		if(employeeResponse!=null) return new ResponseEntity<EmployeeResponse>(employeeResponse,HttpStatus.OK);
		else return new ResponseEntity<String>("No Employee", HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}/{firstName}")
	public ResponseEntity<String> updateFirstName(@PathVariable long id, @PathVariable String firstName){
		String response = employeeService.updateFirstName(id, firstName);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	
}
