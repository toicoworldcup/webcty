package com.example.webcty.repositories;

import com.example.webcty.entities.Employee;
import com.example.webcty.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUsername(String username);
    Optional<Employee> findByRole(Role role);
    Optional<Employee> findByEmcode(String emcode);}

