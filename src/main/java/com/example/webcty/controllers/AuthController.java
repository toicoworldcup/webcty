package com.example.webcty.controllers;

import com.example.webcty.dto.request.EmployeeRequest;
import com.example.webcty.config.security.JwtUtil;
import com.example.webcty.dto.response.EmployeeResponse;
import com.example.webcty.entities.Employee;
import com.example.webcty.services.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")

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
    public ResponseEntity<?> register(@RequestBody EmployeeResponse employeeResponse) {
        if (employeeService.findByUsername(employeeResponse.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already taken");
        }

        String encodedPassword = passwordEncoder.encode(employeeResponse.getPassword());
        Employee newEmployee = new Employee();
        newEmployee.setEmCode(employeeResponse.getEmCode());
        newEmployee.setUsername(employeeResponse.getUsername());
        newEmployee.setEmail(employeeResponse.getEmail());
        newEmployee.setPassword(encodedPassword);
        newEmployee.setRole(employeeResponse.getRole());
        employeeService.createEmployee(newEmployee);

        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody EmployeeRequest employeeRequest) {
        Employee employee = employeeService.findByUsername(employeeRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtUtil.generateToken(employee.getUsername(), employee.getRole().name());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("role", employee.getRole().name());

        return ResponseEntity.ok(response);
    }
}
