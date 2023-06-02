package com.stackroute.lifecycleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.lifecycleapi.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, String>{

}
