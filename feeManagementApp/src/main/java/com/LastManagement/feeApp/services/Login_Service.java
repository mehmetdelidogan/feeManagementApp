package com.LastManagement.feeApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LastManagement.feeApp.DAO.Accountant_DAO;
import com.LastManagement.feeApp.DAO.Student_DAO;
import com.LastManagement.feeApp.DAO.User_DAO;
import com.LastManagement.feeApp.Entity.Accountant;
import com.LastManagement.feeApp.Entity.Student;
import com.LastManagement.feeApp.Entity.User;


@Service
public class Login_Service {
	
    @Autowired(required=true)
    private User_DAO user_DAO;

    @Autowired
    private Student_DAO student_DAO;

    @Autowired
    private Accountant_DAO accountant_DAO;

    public User authenticateUser(User user) {
        User authUser = new User();

        if (user.getEmail().equals("admin") && user.getPassword().equals("admin")) {
            authUser.setId(1L);
            authUser.setEmail("admin@admin.com");

            user_DAO.findAll().forEach(userdb -> {
                if (user.getEmail().equals(userdb.getEmail()) && user.getPassword().equals(userdb.getPassword())) {
                    authUser.setEmail(userdb.getEmail());
                    authUser.setRoles(userdb.getRoles());

                    Student student = student_DAO.findByEmail(userdb.getEmail());
                    Accountant accountant = accountant_DAO.findByEmail(userdb.getEmail());

                    if (student == null && accountant != null) {
                        authUser.setId(accountant.getId());
                    }else {
                        authUser.setId(student.getStudent_rollno());
                    }
                }
            });
        }
        return authUser;
    }

}
