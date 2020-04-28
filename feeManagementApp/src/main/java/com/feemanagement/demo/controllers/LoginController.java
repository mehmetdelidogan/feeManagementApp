package com.feemanagement.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feemanagement.demo.Entity.User;
import com.feemanagement.demo.services.Login_Service;



@RestController
public class LoginController {

    @Autowired
    private Login_Service login_Service;

    @PostMapping("/login")
    public User authenticate(@Validated @RequestBody User user) {

        return login_Service.authenticateUser(user);
    }

}
