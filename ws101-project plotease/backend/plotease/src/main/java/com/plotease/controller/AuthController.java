package com.plotease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plotease.dto.LoginRequest;
import com.plotease.dto.SignupRequest;
import com.plotease.model.User;
import com.plotease.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public User signup(@RequestBody SignupRequest req) {

        User user = new User();
        user.setUserId(req.getUserId());
        user.setFullName(req.getFullName());
        user.setStudentId(req.getStudentId());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());

        return service.signup(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest req) {
        return service.login(req.getEmail(), req.getPassword());
    }
}