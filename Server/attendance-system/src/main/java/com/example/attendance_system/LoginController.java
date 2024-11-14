package com.example.attendance_system;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    // JWT Util instance
    private JwtUtil jwtUtil = new JwtUtil();

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Validate credentials (you can replace this with a real user authentication
        // process)
        if ("admin".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
            // Generate JWT token
            String token = jwtUtil.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok("Bearer " + token); // Return token with "Bearer" prefix
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
