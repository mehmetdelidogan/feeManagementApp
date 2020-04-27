package com.LastManagement.feeApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LastManagement.feeApp.DAO.Accountant_DAO;
import com.LastManagement.feeApp.Entity.Student;
import com.LastManagement.feeApp.repositories.StudentDto;

@Service
public class Accountant_Service {
	 @Autowired
	    private Accountant_DAO accountant_DAO;

	    public List<Student> getAllStudents() {

	        return accountant_DAO.getStudents();
	    }

	    public Student getStudent(int id) {
	        return accountant_DAO.findById(id);
	    }

	    public void createStudent(StudentDto studentDto) {
	        Student student = new Student();
	        student.setStudent_name(studentDto.getName());
	        student.setStudent_email(studentDto.getEmail());

	        accountant_DAO.save(student);
	    }

	    public void deleteStudent(int id) {
	        accountant_DAO.deleteById(id);
	    }
}
