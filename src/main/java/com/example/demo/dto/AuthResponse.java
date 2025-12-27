// package com.example.demo.dto;

// public class AuthResponse {
//     private String token;
//     private Long userId;
//     private String email;
//     private String role;

//     // No-arg constructor (required by Spring / Jackson)
//     public AuthResponse() {}

//     // All-args constructor (to use in your controller)
//     public AuthResponse(String token, Long userId, String email, String role) {
//         this.token = token;
//         this.userId = userId;
//         this.email = email;
//         this.role = role;
//     }

//     // Getters and setters
//     public String getToken() { return token; }
//     public void setToken(String token) { this.token = token; }

//     public Long getUserId() { return userId; }
//     public void setUserId(Long userId) { this.userId = userId; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }
// }
// package com.example.demo.dto;

// public class AuthResponse {
//     private String token;
//     private Long id;
//     private String email;
//     private String role;

//     public AuthResponse(String token, Long id, String email, String role) {
//         this.token = token;
//         this.id = id;
//         this.email = email;
//         this.role = role;
//     }

//     // getters and setters
//     public String getToken() { return token; }
//     public void setToken(String token) { this.token = token; }
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }
//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }
// }
package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private Long userId;
    private String email;
    private String role;

    // ✅ REQUIRED by Spring / Jackson
    public AuthResponse() {}

    // ✅ REQUIRED by AuthController (login & register)
    public AuthResponse(String token) {
        this.token = token;
    }

    // ✅ REQUIRED by TEST CASES
    public AuthResponse(String token, Long userId, String email, String role) {
        this.token = token;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
