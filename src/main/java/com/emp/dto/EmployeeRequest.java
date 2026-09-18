package com.emp.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class EmployeeRequest {

	@NotBlank(message = "Given data is blank")
    @NotNull(message = "Give data is null")
    @NotEmpty(message = "Given data is Empty")
    private String firstName;
	@NotBlank
    @NotNull
    @NotEmpty
    private String lastName;
    @Email
    @NotBlank
    @NotNull
    @NotEmpty
    private String email;
    @NotBlank
    @NotNull
    @NotEmpty
    private String phone;
    @NotBlank
    @NotNull
    @NotEmpty
    private String department;
    private String designation;
    private Double salary;
	public EmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeRequest(String firstName, String lastName, String email, String phone, String department,
			String designation, Double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
     
    
}
