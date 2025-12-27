package com.example.demo.dto;

import com.example.demo.model.User;

public class AuthRequest {

    private String email;
    private String password;
    private String role; // optional

    // Getters and setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    // Add this method
    public User toUser() {
        User user = new User();
        user.setEmail(this.email);
        user.setPassword(this.password);
        if (this.role != null) {
            user.setRole(this.role);
        }
        return user;
    }
}
