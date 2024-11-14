package com.example.attendance_system;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
    // Secret key to sign the JWT
    private String secretKey = "your_secret_key"; // Change this to a stronger secret key

    // Method to generate JWT token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Token valid for 1 hour
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
