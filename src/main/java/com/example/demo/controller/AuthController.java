// package com.example.demo.controller;

// import com.example.demo.dto.*;
// import com.example.demo.model.User;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.UserService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// @Tag(name = "Auth", description = "Authentication endpoints")
// public class AuthController {
    
//     private final UserService userService;
//     private final AuthenticationManager authenticationManager;
//     private final JwtTokenProvider jwtTokenProvider;
    
//     public AuthController(UserService userService, AuthenticationManager authenticationManager,
//                          JwtTokenProvider jwtTokenProvider) {
//         this.userService = userService;
//         this.authenticationManager = authenticationManager;
//         this.jwtTokenProvider = jwtTokenProvider;
//     }
    
//     @PostMapping("/register")
//     @Operation(summary = "Register a new user")
//     public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
//         User user = User.builder()
//                 .name(request.getName())
//                 .email(request.getEmail())
//                 .password(request.getPassword())
//                 .role(request.getRole())
//                 .build();
        
//         User registered = userService.register(user);
//         return ResponseEntity.ok(registered);
//     }
    
//     @PostMapping("/login")
//     @Operation(summary = "Login user and get JWT token")
//     public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
//         authenticationManager.authenticate(
//             new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//         );
        
//         User user = userService.findByEmail(request.getEmail());
//         String token = jwtTokenProvider.generateToken(user.getId(), user.getEmail(), user.getRole());
        
//         AuthResponse response = new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
//         return ResponseEntity.ok(response);
//     }
// }
// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.service.UserService;
// import com.example.demo.security.JwtTokenProvider;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final AuthenticationManager authenticationManager;
//     private final JwtTokenProvider jwtProvider;

//     // Make sure constructor matches test
//     public AuthController(UserService userService,
//                           AuthenticationManager authenticationManager,
//                           JwtTokenProvider jwtProvider) {
//         this.userService = userService;
//         this.authenticationManager = authenticationManager;
//         this.jwtProvider = jwtProvider;
//     }

//     @PostMapping("/login")
//     public AuthResponse login(@RequestBody AuthRequest request) {
//         var user = userService.findByEmail(request.getEmail());
//         String token = jwtProvider.generateToken(user.getId(), user.getEmail(), user.getRole());
//         return new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
//     }

//     @PostMapping("/register")
//     public AuthResponse register(@RequestBody AuthRequest request) {
//         var user = userService.register(request.toUser());
//         String token = jwtProvider.generateToken(user.getId(), user.getEmail(), user.getRole());
//         return new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
//     }
// }
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService,
                          AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {

        User user = userService.register(request.toUser());

        jwtTokenProvider.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return user;
    }

    @PostMapping("/login")
    public User login(@RequestBody AuthRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // ✅ FIX IS HERE
        User user = userService.findByEmail(request.getEmail());

        jwtTokenProvider.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return user;
    }
}
