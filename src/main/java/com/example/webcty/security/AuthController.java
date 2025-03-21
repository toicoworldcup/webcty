package com.example.webcty.security;

import com.example.webcty.entities.Employee;
import com.example.webcty.services.impl.EmployeeServiceImpl;
import com.example.webcty.security.AuthRequest;
import com.example.webcty.security.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")  // Cho phép tất cả các domain

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
        // Kiểm tra nếu người dùng đã tồn tại
        if (employeeService.findByUsername(registerRequest.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already taken");
        }

        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        Employee newEmployee = new Employee();
        newEmployee.setEmCode(registerRequest.getEmCode());
        newEmployee.setUsername(registerRequest.getUsername());
        newEmployee.setEmail(registerRequest.getEmail());
        newEmployee.setPassword(encodedPassword);
        newEmployee.setRole(registerRequest.getRole());

        employeeService.createEmployee(newEmployee);

        return ResponseEntity.ok("User registered successfully!");
    }

    // Đăng nhập và nhận token
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        Employee employee = employeeService.findByUsername(authRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtUtil.generateToken(employee.getUsername(), employee.getRole().name());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("role", employee.getRole().name());

        return ResponseEntity.ok(response);
    }
}
