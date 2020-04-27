package com.LastManagement.feeApp.DAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LastManagement.feeApp.Entity.Accountant;
import com.LastManagement.feeApp.Entity.Student;


@Repository
@Transactional
public class Accountant_DAO_Imp implements Accountant_DAO {

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
	public void addStudent(Student studentmodel) {

		getSession().save(studentmodel);
	}

	@Override
	public List<Student> getStudents() {

		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		Root<Student> myObjectRoot = criteria.from(Student.class);
		criteria.select(myObjectRoot);
		TypedQuery<Student> query = getSession().createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public Student findById(int id) {

		Student studentModel = getSession().get(Student.class, id);
		return studentModel;
	}

	@Override
	public Student update(Student studentModel, int id) {

		Student studentToUpdate = findById(id);
		studentToUpdate.setStudent_rollno(studentModel.getStudent_rollno());
		studentToUpdate.setStudent_name(studentModel.getStudent_name());
		getSession().update(studentToUpdate);
		return studentToUpdate;
	}

	@Override
	public void delete(int id) {

		Student studentToDelete = findById(id);
		getSession().delete(studentToDelete);
	}
	@Override
    public Accountant findByEmail(String email) {
        return getSession().get(Accountant.class,email);
    }
	
	 @Override
	    public void save(Student student) {

	        getSession().saveOrUpdate(student);
	    }
	 
	 @Override
	    public void deleteById(int id) {
	        getSession().createQuery("DELETE FROM Accountant WHERE id=:id_del")
	        .setParameter("id_del", id)
	        .executeUpdate();
	    }

}
