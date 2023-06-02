package com.stackroute.samplejpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.samplejpa.model.Employee;
import com.stackroute.samplejpa.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo emprepo;
	
	@Override
	public Employee addEmployee(Employee newEmp) {
		
		Employee resultemp = emprepo.save(newEmp);
		
		return resultemp;
	}

	@Override
	public List<Employee> viewEmployees() {
		
		List<Employee> employees = emprepo.findAll();
		return employees;
	}

	@Override
	public Employee findEmployee(String empid) {
		
		Optional<Employee> empopt = emprepo.findById(empid);
		if(empopt.isEmpty()) {
			return null;
		}
		return empopt.get();
	}

}
