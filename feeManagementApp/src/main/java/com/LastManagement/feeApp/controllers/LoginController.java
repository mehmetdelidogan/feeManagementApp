package com.LastManagement.feeApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LastManagement.feeApp.Entity.User;
import com.LastManagement.feeApp.services.Login_Service;



@RestController
public class LoginController {

    @Autowired
    private Login_Service login_Service;

    @PostMapping("/login")
    public User authenticate(@Validated @RequestBody User user) {

        return login_Service.authenticateUser(user);
    }

}
