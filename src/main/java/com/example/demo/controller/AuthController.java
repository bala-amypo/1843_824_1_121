package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import com.example.demo.exception.ApiException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwtProvider;

    @Autowired
    public AuthController(UserService userService,
                          AuthenticationManager authManager,
                          JwtTokenProvider jwtProvider) {
        this.userService = userService;
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody User user) {
        User savedUser = userService.register(user);
        String token = jwtProvider.generateToken(savedUser.getEmail());
        return new AuthResponse(token, savedUser.getId(), savedUser.getEmail(), savedUser.getRole());
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody User user) {
        try {
            Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
            User loggedUser = userService.findByEmail(user.getEmail());
            String token = jwtProvider.generateToken(loggedUser.getEmail());
            return new AuthResponse(token, loggedUser.getId(), loggedUser.getEmail(), loggedUser.getRole());
        } catch (AuthenticationException ex) {
            throw new ApiException("Invalid email/password");
        }
    }
}
