package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf->csrf.disable()).securityMatcher("/api/**").authorizeHttpRequests(auth->{
            auth.requestMatchers("/users/**").hasRole("user");
            auth.requestMatchers("/admin/**").hasRole("admin");
            auth.requestMatchers("/api/users/**")
        });
    }
}
