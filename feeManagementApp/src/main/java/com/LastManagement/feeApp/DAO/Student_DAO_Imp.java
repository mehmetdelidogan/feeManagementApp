package com.LastManagement.feeApp.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LastManagement.feeApp.Entity.Student;

@Repository
public class Student_DAO_Imp implements Student_DAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		if (session == null) {
			sessionFactory.openSession();
		}
		return session;
	}

	@Override
	public Student findById(Long id) {

		return getSession().get(Student.class, id);
	}

	@Override
	public void save(Student student) {

		getSession().saveOrUpdate(student);
	}

	@Override
	public Student findByEmail(String email) {
		return getSession().get(Student.class, email);
	}

}
