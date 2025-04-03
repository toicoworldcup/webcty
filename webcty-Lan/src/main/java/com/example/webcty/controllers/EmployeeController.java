package com.example.webcty.controllers;

import com.example.webcty.dto.response.EmployeeResponse;
import com.example.webcty.entities.Employee;
import com.example.webcty.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        List<EmployeeResponse> employeeDTOs = employees.stream()
                .map(employee -> new EmployeeResponse(
                        employee.getId(),
                        employee.getEmCode(),
                        employee.getUsername(),
                        employee.getEmail(),
                        employee.getRole().name()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(employeeDTOs);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/id/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeByEmcode(@PathVariable String id) {
        Employee employee = employeeService.getEmployeeByEmcode(id);
        EmployeeResponse employeeDTO = new EmployeeResponse(
                employee.getId(),
                employee.getEmCode(),
                employee.getUsername(),
                employee.getEmail(),
                employee.getRole().name()
        );

        return ResponseEntity.ok(employeeDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/username/{username}")
    public ResponseEntity<EmployeeResponse> getEmployeeByUsername(@PathVariable String username) {
        Employee employee = employeeService.getEmployeeByUsername(username);
        EmployeeResponse employeeDTO = new EmployeeResponse(
                employee.getId(),
                employee.getEmCode(),
                employee.getUsername(),
                employee.getEmail(),
                employee.getRole().name()
        );

        return ResponseEntity.ok(employeeDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/id/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.updateEmployee(id, updatedEmployee);
        EmployeeResponse employeeDTO = new EmployeeResponse(
                employee.getId(),
                employee.getEmCode(),
                employee.getUsername(),
                employee.getEmail(),
                employee.getRole().name()
        );

        return ResponseEntity.ok(employeeDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
