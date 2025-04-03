package com.example.webcty.controllers;

import com.example.webcty.config.security.JwtUtil;
import com.example.webcty.dto.request.LoginRequest;
import com.example.webcty.dto.request.RegisterRequest;
import com.example.webcty.dto.response.AuthResponse;
import com.example.webcty.entities.Employee;
import com.example.webcty.enums.Role;
import com.example.webcty.services.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        if (employeeService.findByUsername(registerRequest.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already taken");
        }

        Employee newEmployee = new Employee();
        newEmployee.setEmCode(registerRequest.getEmCode());
        newEmployee.setUsername(registerRequest.getUsername());
        newEmployee.setEmail(registerRequest.getEmail());
        newEmployee.setPassword(passwordEncoder.encode(registerRequest.getPassword())); // Mã hóa mật khẩu
        newEmployee.setRole(Role.valueOf(registerRequest.getRole().toUpperCase()));

        Employee savedEmployee = employeeService.createEmployee(newEmployee);

        // Tạo token JWT
        String token = jwtUtil.generateToken(savedEmployee.getUsername(), savedEmployee.getRole().name());

        return ResponseEntity.ok(new AuthResponse(token, savedEmployee.getRole().name()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Employee employee = employeeService.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Kiểm tra mật khẩu
        if (!passwordEncoder.matches(loginRequest.getPassword(), employee.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid password");
        }

        String token = jwtUtil.generateToken(employee.getUsername(), employee.getRole().name());

        return ResponseEntity.ok(new AuthResponse(token, employee.getRole().name()));
    }

}
