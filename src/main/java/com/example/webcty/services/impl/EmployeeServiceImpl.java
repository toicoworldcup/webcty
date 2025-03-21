package com.example.webcty.services.impl;

import com.example.webcty.entities.Employee;
import com.example.webcty.repositories.EmployeeRepository;
import com.example.webcty.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        // Trả về null nếu không tìm thấy hoặc có thể ném ngoại lệ
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        // Nếu không tìm thấy, có thể ném ngoại lệ
        return employeeRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Employee with username " + username + " not found"));
    }

    @Override
    public Employee createEmployee(Employee employee) {
        // Lưu nhân viên vào cơ sở dữ liệu
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        // Kiểm tra nếu nhân viên đã tồn tại trước khi cập nhật
        Employee employee = getEmployeeById(id);

        // Cập nhật thông tin nhân viên
        employee.setUsername(updatedEmployee.getUsername());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setPassword(updatedEmployee.getPassword());
        employee.setEmCode(updatedEmployee.getEmCode());
        employee.setRole(updatedEmployee.getRole());

        // Lưu lại nhân viên đã cập nhật
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        // Kiểm tra nhân viên có tồn tại trước khi xóa
        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Tìm người dùng từ cơ sở dữ liệu
        Employee employee = employeeRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // Trả về một đối tượng UserDetails từ Spring Security
        return User.builder()
                .username(employee.getUsername())
                .password(employee.getPassword())
                .authorities("ROLE_" + employee.getRole().name()) // Thêm "ROLE_" vào quyền
                .build();
    }
}
