package com.example.pre_capstone_fullstack.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disabilita CSRF per le richieste POST
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // Permette tutte le richieste senza autenticazione
        return http.build();
    }
}