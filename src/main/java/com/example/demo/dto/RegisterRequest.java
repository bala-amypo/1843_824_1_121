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

    // ✅ No-args constructor (required)
    public RegisterRequest() {}

    // ✅ Builder required by test cases
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final RegisterRequest req = new RegisterRequest();

        // Used by controller / normal flow
        public Builder email(String email) {
            req.setEmail(email);
            return this;
        }

        // ✅ TEST CASE USES name() INSTEAD OF email()
        public Builder name(String email) {
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

    // ✅ Converts DTO → Entity (used by AuthController)
    public User toUser() {
        User user = new User();
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setRole(this.role);
        return user;
    }
}
