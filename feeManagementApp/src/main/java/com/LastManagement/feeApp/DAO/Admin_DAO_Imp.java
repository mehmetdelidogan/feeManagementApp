package com.LastManagement.feeApp.DAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LastManagement.feeApp.Entity.Accountant;
import com.LastManagement.feeApp.Entity.Student;

@Repository
@Transactional
public class Admin_DAO_Imp  implements Admin_DAO{
	
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
	public void addAccountant(Accountant accountant) {
		
		getSession().save(accountant);
	}

	
	@Override
	public List<Accountant> getAccountants() {
		
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Accountant> criteria = builder.createQuery(Accountant.class);
	    Root<Accountant> myObjectRoot = criteria.from(Accountant.class);
	    criteria.select(myObjectRoot);
		TypedQuery<Accountant> query = getSession().createQuery(criteria);
		return query.getResultList();
	}
	
   @Override
    public List<Student> findAllStudent() {
        Query<Student> query = getSession().createQuery("FROM Student", Student.class);
        return query.getResultList();
    }
	

	@Override
	public Accountant findById(int id) {
		
		Accountant accountant = getSession().get(Accountant.class, id);
		return accountant;
	}

	
	@Override
	public Accountant update(Accountant accountant, int id) {
		
		Accountant accountantToUpdate = findById(id);
		accountantToUpdate.setName(accountant.getName());
		accountantToUpdate.setEmail(accountant.getEmail());
		getSession().update(accountantToUpdate);
		return accountantToUpdate;
	}

	
	@Override
	public void delete(int id) {
		
	   Accountant accountantToDelete = findById(id);
	   getSession().delete(accountantToDelete);
	}
	
	 @Override
	    public void deleteStudentById(int id) {

	        getSession().createQuery("DELETE FROM Student WHERE id=:idToDelete")
	                .setParameter("idToDelete", id).executeUpdate();
	    }
	 
	 @Override
	    public Student findByIdStudent(int id) {

	        return getSession().get(Student.class,id);
	    }
	 @Override
	    public Accountant findByIdAccountant(int id) {

	        return getSession().get(Accountant.class,id);
	    }
	 
	  @Override
	    public void saveAccountant(Accountant accountant) {
	        getSession().saveOrUpdate(accountant);
	    }
}
