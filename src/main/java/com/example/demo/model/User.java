
// package com.example.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Table;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Column;

// import lombok.Getter;
// import lombok.Setter;
// import lombok.Builder;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;

// @Entity
// @Table(name = "users")
// @Getter
// @Setter
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class User {

//     public enum Role {
//         ADMIN,
//         STUDENT
//     }

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String email;

//     @Column(nullable = false)
//     private String password;

//     @Enumerated(EnumType.STRING)
//     @Column(nullable = false)
//     private Role role;

//     // ✅ Custom constructor (optional)
//     public User(String email, String password, Role role) {
//         this.email = email;
//         this.password = password;
//         this.role = role;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    private String role;
}
