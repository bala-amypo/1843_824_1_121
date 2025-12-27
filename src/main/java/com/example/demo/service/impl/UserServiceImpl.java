
package com.example.demo.service.impl;
import org.springframework.stereotype.Service;

import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import com.example.demo.exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder;

    @Override
    public User register(User user) {
        if (user.getRole() == null) user.setRole("STAFF");
        if (userRepo.findByEmail(user.getEmail()).isPresent())
            throw new ApiException("User already exists");
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new ApiException("User not found"));
    }
}
