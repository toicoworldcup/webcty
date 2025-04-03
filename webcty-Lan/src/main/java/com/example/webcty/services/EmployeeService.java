package com.example.webcty.services;

import com.example.webcty.entities.Employee;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    // Lấy tất cả danh sách nhân viên
    List<Employee> getAllEmployees();

    // Lấy nhân viên theo ID
    Employee getEmployeeByEmcode(String id);

    // Lấy nhân viên theo username
    Employee getEmployeeByUsername(String username);

    // Tạo mới nhân viên
    Employee createEmployee(Employee employee);

    // Cập nhật thông tin nhân viên
    Employee updateEmployee(String id, Employee updatedEmployee);

    // Xóa nhân viên theo ID
    void deleteEmployee(Long id);

    // Tìm nhân viên theo username (dành cho xác thực người dùng)
    Optional<Employee> findByUsername(String username);

    UserDetails loadUserByUsername(String username);}
