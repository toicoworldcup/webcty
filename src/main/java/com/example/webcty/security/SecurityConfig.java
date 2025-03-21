package com.example.webcty.security;

import com.example.webcty.repositories.EmployeeRepository;
import com.example.webcty.entities.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> auth

                        .requestMatchers("/api/auth/login").permitAll()
                        .requestMatchers("/api/company-details/{id}").permitAll()
                        .requestMatchers("/api/company-history").permitAll()
                        .requestMatchers("/api/company-history/{id}").permitAll()
                        .requestMatchers("/api/company-info").permitAll()
                        .requestMatchers("/api/company-info/{id}").permitAll()
                        .requestMatchers("/api/company-members").permitAll()
                        .requestMatchers("/api/company-members/{id}").permitAll()
                        .requestMatchers("/api/customer-contacts").permitAll()
                        .requestMatchers("/api/customer-contacts/{id}").permitAll()
                        .requestMatchers("/api/media-files").permitAll()
                        .requestMatchers("/api/media-files//type/{entityType}").permitAll()
                        .requestMatchers("/type/{entityType}/{entityId}").permitAll()
                        .requestMatchers("/api/news").permitAll()
                        .requestMatchers("/api/news/{id}").permitAll()
                        .requestMatchers("/api/products").permitAll()
                        .requestMatchers("/api/products/{id}").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // Cấu hình stateless
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);  // Thêm JwtFilter trước filter UsernamePasswordAuthenticationFilter

        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(List.of(authProvider));  // Sử dụng ProviderManager với authProvider
    }
    @Bean
    public UserDetailsService userDetailsService(EmployeeRepository employeeRepository) {
        return username -> employeeRepository.findByUsername(username)  // Tìm người dùng theo username
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
