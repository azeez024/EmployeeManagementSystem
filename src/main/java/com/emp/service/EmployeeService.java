package com.emp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emp.dto.EmployeeRequest;
import com.emp.dto.EmployeeResponse;
import com.emp.entity.EmployeeEntity;
import com.emp.exceptions.EmployeeDataNotExists;
import com.emp.repository.EmployeeRepository;



@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DtoAndEntity dtoAndEntity;
	
	public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
		
		EmployeeEntity employeeEntity = dtoAndEntity.dtoToEntity(employeeRequest);
		employeeEntity = employeeRepository.save(employeeEntity);
		return dtoAndEntity.entityToDto(employeeEntity);
		
	}

	public ResponseEntity<EmployeeResponse> getEmployee(long id, String header1) {
		
		System.out.println("Header Receved :"+ header1);
		Optional<EmployeeEntity> optionalEntity = employeeRepository.findById(id);
		if(optionalEntity.isPresent()) {
			EmployeeEntity employeeEntity = optionalEntity.get();
			EmployeeResponse employeeResponse = dtoAndEntity.entityToDto(employeeEntity);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("header1", header1);
			
			return new ResponseEntity<EmployeeResponse>(employeeResponse,httpHeaders,HttpStatus.OK);
		}
		else throw new EmployeeDataNotExists("No data on this id"+id);
	}

	public List<EmployeeResponse> getAllEmployees() {
		List<EmployeeEntity> employees = employeeRepository.findAll();
		List<EmployeeResponse> employeesResponse = new ArrayList<>();
		for(EmployeeEntity eEntity : employees) 
			employeesResponse.add(dtoAndEntity.entityToDto(eEntity));
		return employeesResponse;
	}

	public String deleteEmployee(long id) {
		
		
		Optional<EmployeeEntity> optionalEntity = employeeRepository.findById(id);
		if(optionalEntity.isPresent()) {
			employeeRepository.deleteById(id);
			return "Employee Deleted Successfully";
		}
		else return "Employee Not Exist";
	}

	public String addAllEmployees(List<EmployeeRequest> employees) {
		
		List<EmployeeEntity> entityEmployees = new ArrayList<>();
		for(EmployeeRequest employee : employees) entityEmployees.add(dtoAndEntity.dtoToEntity(employee));
		entityEmployees = employeeRepository.saveAll(entityEmployees);
		if(entityEmployees.isEmpty()) return "Employees are Not Added";
		else return "Employees are Added";
	}

	public EmployeeResponse updateEmployee(EmployeeResponse employeeResponse) {
		EmployeeEntity employeeEntity = dtoAndEntity.dtoToEntityUpdate(employeeResponse);
		employeeEntity = employeeRepository.save(employeeEntity);
		return dtoAndEntity.entityToDto(employeeEntity);
	}

	public List<EmployeeResponse> getEmployeeByDepartment(String department) {
		
		List<EmployeeEntity> employeeEntitys = employeeRepository.findByDepartment(department);
		List<EmployeeResponse> employeeResponse = new ArrayList<>();
		for(EmployeeEntity employee : employeeEntitys) employeeResponse.add(dtoAndEntity.entityToDto(employee));
		
		return employeeResponse;
	}
	
	public List<EmployeeResponse> findBySalaryGreaterThan(int salary){
		List<EmployeeEntity> employees = employeeRepository.findBySalaryGreaterThan(salary);
		List<EmployeeResponse> all = new ArrayList<>();
		for(EmployeeEntity employee : employees) all.add(dtoAndEntity.entityToDto(employee));
		return all;
	}
	
	public List<EmployeeResponse> getEmployeeByPhone(String phone) {
		List<EmployeeEntity> employeeEntitys = employeeRepository.findByPhone(phone);
		List<EmployeeResponse> employeeResponses = new ArrayList<>();
		for(EmployeeEntity employee : employeeEntitys) employeeResponses.add(dtoAndEntity.entityToDto(employee));
		
		return employeeResponses;
	}
	
	public EmployeeResponse getEmployeeByEmail(String email) {
		EmployeeEntity employeeEntity = employeeRepository.findByEmail(email);
		EmployeeResponse employeeResponse = dtoAndEntity.entityToDto(employeeEntity);
		return employeeResponse;
	}
	
	public List<EmployeeResponse> getEmployeesByFirstName(String firstName){
		List<EmployeeEntity> employeeEntities  =  employeeRepository.findByFirstName(firstName);
		List<EmployeeResponse> list = new ArrayList<>();
		for(EmployeeEntity employeeEntity : employeeEntities) list.add(dtoAndEntity.entityToDto(employeeEntity));
		return list;
	}
	
	public List<EmployeeResponse> getEmployeesByLastName(String lastName){
		List<EmployeeEntity> employeeEntities = employeeRepository.findByLastName(lastName);
		List<EmployeeResponse> list = new ArrayList<>();
		for(EmployeeEntity employeeEntity : employeeEntities) list.add(dtoAndEntity.entityToDto(employeeEntity));
		return list;
	}
	
	public EmployeeResponse getEmployeeByIdAndFirstName(long id, String firstName) {
		EmployeeEntity employeeEntity = employeeRepository.findByIdAndFirstName(id, firstName);
		return dtoAndEntity.entityToDto(employeeEntity);
	}
	
	@Modifying
	@Transactional
	public String updateFirstName(long id,String firstName) {
		Optional<EmployeeEntity> optional = employeeRepository.findById(id);
		if(optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			employeeEntity.setFirstName(firstName);
			employeeRepository.save(employeeEntity);
			return "Employee FirstName Updated Successfully";
		}
		else return "Employee FirstName Not Updated";
			
	}
	
}
