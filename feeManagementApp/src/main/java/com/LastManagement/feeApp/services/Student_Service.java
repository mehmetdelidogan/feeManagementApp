package com.LastManagement.feeApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LastManagement.feeApp.DAO.Student_DAO;
import com.LastManagement.feeApp.Entity.Student;
import com.LastManagement.feeApp.repositories.StudentDto;

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
