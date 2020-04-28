package com.feemanagement.demo.DAO;

import com.feemanagement.demo.Entity.Student;

public interface Student_DAO {

	Student findById(Long id);

	void save(Student student);

	Student findByEmail(String email);

}
