// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import java.security.Key;
// import java.util.Date;

// @Component
// public class JwtTokenProvider {

//     @Value("${jwt.secret}")
//     private String secretKey;

//     @Value("${jwt.expiration}")
//     private long validityInMilliseconds;

//     // ✅ REQUIRED for TEST CASES
//     public JwtTokenProvider(String secretKey, long validityInMilliseconds) {
//         this.secretKey = secretKey;
//         this.validityInMilliseconds = validityInMilliseconds;
//     }

//     // ✅ REQUIRED for SPRING
//     public JwtTokenProvider() {
//     }

//     private Key getSigningKey() {
//         return Keys.hmacShaKeyFor(secretKey.getBytes());
//     }

//     public String generateToken(Long userId, String email, String role) {
//         Date now = new Date();
//         Date expiry = new Date(now.getTime() + validityInMilliseconds);

//         return Jwts.builder()
//                 .claim("userId", userId)
//                 .claim("email", email)
//                 .claim("role", role)
//                 .setIssuedAt(now)
//                 .setExpiration(expiry)
//                 .signWith(getSigningKey(), SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder()
//                     .setSigningKey(getSigningKey())
//                     .build()
//                     .parseClaimsJws(token);
//             return true;
//         } catch (JwtException | IllegalArgumentException ex) {
//             return false;
//         }
//     }

//     public Long getUserIdFromToken(String token) {
//         return ((Number) getClaims(token).get("userId")).longValue();
//     }

//     public String getEmailFromToken(String token) {
//         return (String) getClaims(token).get("email");
//     }

//     public String getRoleFromToken(String token) {
//         return (String) getClaims(token).get("role");
//     }

//     private Claims getClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(getSigningKey())
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }
package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private Key key;
    private long EXPIRATION;

    // ✅ REQUIRED BY TESTCASES
    public JwtTokenProvider(String secret, int expirySeconds) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.EXPIRATION = expirySeconds * 1000L;
    }

    // ✅ REQUIRED BY SPRING
    public JwtTokenProvider() {
        this.key = Keys.hmacShaKeyFor(
                "THIS_IS_A_256_BIT_SECRET_KEY_FOR_JWT_AUTHENTICATION"
                        .getBytes()
        );
        this.EXPIRATION = 24 * 60 * 60 * 1000;
    }

    public String generateToken(Long userId, String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("id", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public String getEmailFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String getRoleFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }

    public Long getUserIdFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("id", Long.class);
    }
}
