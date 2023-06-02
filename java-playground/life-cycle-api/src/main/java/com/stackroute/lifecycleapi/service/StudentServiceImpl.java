package com.stackroute.lifecycleapi.service;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.lifecycleapi.exceptions.StudentIdAlreadyExistException;
import com.stackroute.lifecycleapi.model.Student;
import com.stackroute.lifecycleapi.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService  {

	@Autowired
	StudentRepo stRepo;
	
	@Override
	public Student addStuent(Student studentobj) throws StudentIdAlreadyExistException {
		
		Optional<Student> stopt = stRepo.findById(studentobj.getId());
		if(stopt.isPresent()) {
			throw new StudentIdAlreadyExistException("Id is already exist.");
		}
		
		Student res = stRepo.save(studentobj);
		return res;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return stRepo.findAll();
	}

}
