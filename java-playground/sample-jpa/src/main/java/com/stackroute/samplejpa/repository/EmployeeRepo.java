package com.stackroute.samplejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.samplejpa.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {

	
}
