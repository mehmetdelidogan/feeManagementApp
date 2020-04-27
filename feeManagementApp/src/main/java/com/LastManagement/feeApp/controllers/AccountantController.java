package com.LastManagement.feeApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.LastManagement.feeApp.DAO.Accountant_DAO;
import com.LastManagement.feeApp.Entity.Student;

@RestController
@RequestMapping(value="/students")
public class AccountantController {
	
	@Autowired
	Accountant_DAO accountant_Dao;

	@GetMapping(value = "/{student_rollno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudentById(@PathVariable("student_rollno") int student_rollno) {
		System.out.println("Fetching Student with id " + student_rollno);
		Student studentModel = accountant_Dao.findById(student_rollno);
		if (studentModel == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(studentModel, HttpStatus.OK);
	}

	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<Void> createStudent(@RequestBody Student studentModel, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Student " + studentModel.getStudent_name());
		accountant_Dao.addStudent(studentModel);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/accountant/{id}").buildAndExpand(studentModel.getStudent_rollno()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<Student> getAllStudents() {
		List<Student> tasks = accountant_Dao.getStudents();
		return tasks;

	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody Student currentStudent) {
		System.out.println("sd");
		Student studentModel = accountant_Dao.findById(currentStudent.getStudent_rollno());
		if (studentModel == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		accountant_Dao.update(currentStudent, currentStudent.getStudent_rollno());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<Student> deleteUser(@PathVariable("id") int id) {
		Student studentModel = accountant_Dao.findById(id);
		if (studentModel == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		accountant_Dao.delete(id);
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

}
