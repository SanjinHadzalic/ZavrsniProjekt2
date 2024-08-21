package org.springframework.boot.backend.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.filter.JwtAuthFilter;
import org.springframework.boot.backend.service.jwt.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration {

    private final String ROLE_USER = "USER";
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers("/auth/api/v1/login", "/auth/api/v1/refreshToken",
                                "/auth/api/v1/logout", "/auth/api/v1/register").permitAll()
                        .requestMatchers("/generate/**", "/birds/**", "/ringCode/**", "/ringedBird/**", "/users/**").hasAnyRole(ROLE_USER)
                        .requestMatchers("/accuracyOfCoordinates/**",
                                "/accuracyOfDate/**",
                                "/accuracyOfPullusAge/**",
                                "/age/**",
                                "/alula/**",
                                "/billMethod/**",
                                "/broodPatch/**",
                                "/broodSize/**",
                                "/carpalCovert/**",
                                "/catchingLures/**",
                                "/catchingMethods/**",
                                "/circumstancesPresumed/**",
                                "/circumstances/**",
                                "/condition/**",
                                "/euring_code_identifier/**",
                                "/fatScore/**",
                                "/manipulated/**",
                                "/metalRingInformation/**",
                                "/moult/**",
                                "/movedBeforeTheEncounter/**",
                                "/otherMarksInformation/**",
                                "/pectoralMuscleScore/**",
                                "/place/**",
                                "/plumageCode/**",
                                "/primaryIdentificationMethod/**",
                                "/primaryMoult/**",
                                "/pullusAge/**",
                                "/ringingScheme/**",
                                "/sex/**",
                                "/sexingMethod/**",
                                "/stateOfWingPoint/**",
                                "/status/**",
                                "/tarsusMethod/**",
                                "/verificationOfTheMetalRing/**"
                                ).hasAnyRole(ROLE_USER)
                        .requestMatchers("/bugtracking/**").authenticated()
                        .requestMatchers("/h2-console/**", "/api-docs", "/swagger-ui/**", "/api/**").permitAll())
                .authenticationProvider(authenticationProvider())
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .headers().frameOptions().disable();
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
}
