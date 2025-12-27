// package com.example.demo.dto;

// import com.example.demo.model.User;

// public class AuthRequest {

//     private String email;
//     private String password;
//     private String role; // optional

//     // Getters and setters
//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }

//     // Add this method
//     public User toUser() {
//         User user = new User();
//         user.setEmail(this.email);
//         user.setPassword(this.password);
//         if (this.role != null) {
//             user.setRole(this.role);
//         }
//         return user;
//     }
// }
package com.example.demo.dto;

public class AuthRequest {

    private String email;
    private String password;

    // REQUIRED no-args constructor
    public AuthRequest() {
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

    // =========================
    // Builder (REQUIRED by tests)
    // =========================
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final AuthRequest req = new AuthRequest();

        public Builder email(String email) {
            req.setEmail(email);
            return this;
        }

        public Builder password(String password) {
            req.setPassword(password);
            return this;
        }

        public AuthRequest build() {
            return req;
        }
    }
}
