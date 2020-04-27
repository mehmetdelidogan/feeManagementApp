package com.LastManagement.feeApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LastManagement.feeApp.Entity.Student;
import com.LastManagement.feeApp.repositories.StudentDto;
import com.LastManagement.feeApp.services.Student_Service;

@RestController
@RequestMapping(value="/student")
public class StudentController {
	
	  @Autowired
	    private Student_Service student_Service;

	    @GetMapping("/{studentId}")
	    public Student getStudent(Long studentId) {

	        return student_Service.findById(studentId);
	    }

	    @PutMapping("/{sId}")
	    public Student updateStudent(@PathVariable("sId") Long studentId, @RequestBody StudentDto studentDto ) {

	        return student_Service.updateStudent(studentId, studentDto);
	    }

}
