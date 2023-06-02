package com.stackroute.samplejpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.samplejpa.model.Employee;
import com.stackroute.samplejpa.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empservice;
	
	@GetMapping("/home")
	public ResponseEntity<?> getHome() {
		return new ResponseEntity<String>("Welcome home", HttpStatus.OK);
	}
	
	@PostMapping("/employee/add") 
	public ResponseEntity addemployee(@RequestBody Employee emp) {
		
		Employee empresult = empservice.addEmployee(emp);
		
		return new ResponseEntity<Employee
				>(empresult,HttpStatus.CREATED);
	}
	
	@GetMapping("/employee/view")
	public ResponseEntity<List> viewemployee() {
		
		List<Employee> employees = empservice.viewEmployees();
		return new ResponseEntity<List>(employees,HttpStatus.OK);
	}

}
