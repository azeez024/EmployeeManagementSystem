package com.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emp.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{
	public List<EmployeeEntity> findByDepartment(String department);
	
	@Query(value = "SELECT * FROM employee_details WHERE salary > :salary", nativeQuery = true)
    List<EmployeeEntity> findBySalaryGreaterThan(@Param("salary") double salary);
	
	
	List<EmployeeEntity> findByPhone(String phone);
	
	EmployeeEntity findByEmail(String email);
	
	List<EmployeeEntity> findByFirstName(String firstName);
	
	List<EmployeeEntity> findByLastName(String lastName);
	
	EmployeeEntity findByIdAndFirstName(long id, String firstName);
}
