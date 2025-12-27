package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import com.example.demo.exception.ApiException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @Override
    public User register(User user) {
        if (user.getRole() == null) {
            user.setRole("STAFF");
        }

        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new ApiException("User already exists");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new ApiException("User not found"));
    }
}
