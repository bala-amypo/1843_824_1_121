// package com.example.demo.dto;

// import lombok.Builder;
// import lombok.Data;

// @Data
// @Builder
// public class RegisterRequest {
//     private String name;
//     private String email;
//     private String password;
//     private String role;
// }
package com.example.demo.dto;

import com.example.demo.model.User;

public class RegisterRequest {

    private String email;
    private String password;
    private String role;

    // no-args constructor (REQUIRED)
    public RegisterRequest() {
    }

    // getters & setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // =========================
    // Builder (REQUIRED by tests)
    // =========================
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final RegisterRequest req = new RegisterRequest();

        public Builder email(String email) {
            req.setEmail(email);
            return this;
        }

        public Builder password(String password) {
            req.setPassword(password);
            return this;
        }

        public Builder role(String role) {
            req.setRole(role);
            return this;
        }

        public RegisterRequest build() {
            return req;
        }
    }

    // Optional helper (safe to keep)
    public User toUser() {
        User user = new User();
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setRole(this.role);
        return user;
    }
}
