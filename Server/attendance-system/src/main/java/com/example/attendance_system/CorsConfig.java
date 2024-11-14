package com.example.attendance_system;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig {
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        CorsFilter corsFilter = new CorsFilter();
        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>(corsFilter);

        // Set allowed origins, methods, and headers
        registrationBean.addUrlPatterns("/api/*"); // Allow CORS only on certain URLs
        registrationBean.addInitParameter("allowedOrigins", "http://localhost:3000"); // Replace with the React app URL
                                                                                      // if different
        registrationBean.addInitParameter("allowedMethods", "GET, POST, PUT, DELETE, OPTIONS"); // Allow all HTTP
                                                                                                // methods
        registrationBean.addInitParameter("allowedHeaders", "*"); // Allow all headers

        return registrationBean;
    }
}
