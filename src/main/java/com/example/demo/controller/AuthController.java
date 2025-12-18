package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController

public class AuthController {

    UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/auth/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
    @PostMapping("/auth/login")
    public User login(@RequestBody User user) {
        return userService.findByEmail(user.getEmail());
    }
}
