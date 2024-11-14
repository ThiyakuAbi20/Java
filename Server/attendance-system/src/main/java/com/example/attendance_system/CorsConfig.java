package com.example.attendance_system;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        // Allow CORS on specific endpoints for only POST method
        registry.addMapping("/api/*")
                .allowedOrigins("http://localhost:3000") // Replace with your React app URL
                .allowedMethods("POST") // Allow only POST method
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow credentials if needed (optional)
    }
}