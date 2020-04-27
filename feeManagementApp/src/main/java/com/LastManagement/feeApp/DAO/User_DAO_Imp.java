package com.LastManagement.feeApp.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LastManagement.feeApp.Entity.User;


@Repository
public class User_DAO_Imp implements User_DAO{
	
	@Autowired
    private SessionFactory sf;

    public Session getSession() {
        Session session = sf.getCurrentSession();
        if (session == null) {
            sf.openSession();
        }
        return session;
    }

    @Override
    public void save(User user) {

        getSession().saveOrUpdate(user);
    }

    @Override
    public List<User> findAll() {

        Query<User> query = getSession().createQuery("FROM User", User.class);
        List<User> users = query.getResultList();
        return users;
    }
    @Override
    public User findByEmail(String email){
        return getSession().get(User.class,email);

    }


}
