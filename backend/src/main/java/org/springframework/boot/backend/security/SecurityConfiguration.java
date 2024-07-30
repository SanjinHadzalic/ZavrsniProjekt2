package org.springframework.boot.backend.security;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.filter.JwtAuthFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration {
    private JwtAuthFilter jwtAuthFilter;

}
