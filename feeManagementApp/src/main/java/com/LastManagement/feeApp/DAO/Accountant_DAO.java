package com.LastManagement.feeApp.DAO;

import java.util.List;

import com.LastManagement.feeApp.Entity.Accountant;
import com.LastManagement.feeApp.Entity.Student;


public interface Accountant_DAO {
	
	public void addStudent(Student studentModel);

	public List<Student> getStudents();

	public Student findById(int id);

	public Student update(Student studentModel, int id);

	public void delete(int id);
	
	 Accountant findByEmail(String email);
	 
	 void save(Student student);
	 
	 void deleteById(int id);
}
