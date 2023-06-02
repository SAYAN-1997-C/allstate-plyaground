package com.stackroute.samplejpa.service;

import java.util.List;

import com.stackroute.samplejpa.model.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee newEmp);
	List<Employee> viewEmployees();
	
	Employee findEmployee(String empid);

}
