package com.stackroute.lifecycleapi.service;

import java.util.List;

import com.stackroute.lifecycleapi.exceptions.StudentIdAlreadyExistException;
import com.stackroute.lifecycleapi.model.Student;

public interface StudentService {
	
	Student addStuent(Student studentobj) throws StudentIdAlreadyExistException;
	
	List<Student> getAllStudent();

}
