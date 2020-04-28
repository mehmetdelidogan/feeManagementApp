package com.feemanagement.demo.DAO;

import java.util.List;

import com.feemanagement.demo.Entity.User;


public interface User_DAO {

	void save(User user);

	List<User> findAll();

	User findByEmail(String email);

}
