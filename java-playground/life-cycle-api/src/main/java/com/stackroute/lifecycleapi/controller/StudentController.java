package com.stackroute.lifecycleapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.lifecycleapi.exceptions.StudentIdAlreadyExistException;
import com.stackroute.lifecycleapi.model.Student;
import com.stackroute.lifecycleapi.service.StudentService;
import com.stackroute.lifecycleapi.service.StudentServiceImpl;

@RestController
@RequestMapping("/student/")
@CrossOrigin
public class StudentController {
	
	@Autowired
	StudentService stService;
	
	@PostMapping("/addstudent")
	public ResponseEntity<?> addstudent(@RequestBody Student newsStudent) {
		
		try {
			Student res = stService.addStuent(newsStudent);
			return new ResponseEntity<Student>(res,HttpStatus.CREATED);
		} catch (StudentIdAlreadyExistException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<?> viewall() {
		List<Student> res = stService.getAllStudent();
		return new ResponseEntity<List>(res,HttpStatus.OK);
	}

}
