package com.emp.service;

import org.springframework.stereotype.Component;

import com.emp.dto.EmployeeRequest;
import com.emp.dto.EmployeeResponse;
import com.emp.entity.EmployeeEntity;

@Component
public class DtoAndEntity {

	public EmployeeEntity dtoToEntity(EmployeeRequest employeeRequest) {
		if(employeeRequest==null) return null;
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setFirstName(employeeRequest.getFirstName());
		employeeEntity.setLastName(employeeRequest.getLastName());
		employeeEntity.setEmail(employeeRequest.getEmail());
		employeeEntity.setPhone(employeeRequest.getPhone());
		employeeEntity.setSalary(employeeRequest.getSalary());
		employeeEntity.setDepartment(employeeRequest.getDepartment());
		employeeEntity.setDesignation(employeeRequest.getDesignation());
		return employeeEntity;
	}
	
	public EmployeeResponse entityToDto(EmployeeEntity employeeEntity) {
		if(employeeEntity==null) return null;
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setId(employeeEntity.getId());
		employeeResponse.setFirstName(employeeEntity.getFirstName());
		employeeResponse.setLastName(employeeEntity.getLastName());
		employeeResponse.setEmail(employeeEntity.getEmail());
		employeeResponse.setPhone(employeeEntity.getPhone());
		employeeResponse.setSalary(employeeEntity.getSalary());
		employeeResponse.setDepartment(employeeEntity.getDepartment());
		employeeResponse.setDesignation(employeeEntity.getDesignation());
		
		return employeeResponse;
		
	}
	
	public EmployeeEntity dtoToEntityUpdate(EmployeeResponse employeeResponse) {
		if(employeeResponse==null) return null;
		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		employeeEntity.setId(employeeResponse.getId());
		employeeEntity.setFirstName(employeeResponse.getFirstName());
		employeeEntity.setLastName(employeeResponse.getLastName());
		employeeEntity.setEmail(employeeResponse.getEmail());
		employeeEntity.setPhone(employeeResponse.getPhone());
		employeeEntity.setSalary(employeeResponse.getSalary());
		employeeEntity.setDepartment(employeeResponse.getDepartment());
		employeeEntity.setDesignation(employeeResponse.getDesignation());
		return employeeEntity;
	}
}
