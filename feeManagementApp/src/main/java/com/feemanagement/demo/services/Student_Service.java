package com.feemanagement.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feemanagement.demo.DAO.Student_DAO;
import com.feemanagement.demo.Entity.Student;
import com.feemanagement.demo.repositories.StudentDto;

@Service
public class Student_Service {

	@Autowired
	private Student_DAO student_DAO;

	//@Autowired
	//private User_DAO user_DAO;

	public Student findById(Long id) {

		return student_DAO.findById(id);
	}

	public Student updateStudent(Long studentId, StudentDto student) {
		Student updateStudent = student_DAO.findById(studentId);

		updateStudent.setStudent_name(student.getName());
		updateStudent.setStudent_email(student.getEmail());

		student_DAO.save(updateStudent);
		return updateStudent;
	}
}
