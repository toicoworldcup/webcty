package com.example.webcty.controllers;

import com.example.webcty.dto.response.EmployeeResponse;
import com.example.webcty.entities.Employee;
import com.example.webcty.services.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody EmployeeResponse employeeResponse) {
        if (employeeService.findByUsername(employeeResponse.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already taken");
        }

        Employee newEmployee = new Employee();
        newEmployee.setEmCode(employeeResponse.getEmCode());
        newEmployee.setUsername(employeeResponse.getUsername());
        newEmployee.setEmail(employeeResponse.getEmail());
        newEmployee.setPassword(employeeResponse.getPassword()); // Lưu mật khẩu dưới dạng plain text
        newEmployee.setRole(employeeResponse.getRole());
        employeeService.createEmployee(newEmployee);

        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody EmployeeResponse employeeRequest) {
        Employee employee = employeeService.findByUsername(employeeRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!employee.getPassword().equals(employeeRequest.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid password");
        }

        return ResponseEntity.ok(employee);
    }
}
