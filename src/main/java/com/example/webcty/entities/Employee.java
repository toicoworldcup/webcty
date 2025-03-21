package com.example.webcty.entities;

import com.example.webcty.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import com.example.webcty.enums.Role;

@Entity
@Table(name = "employees")
@AllArgsConstructor
public class Employee implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String username;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, unique = true, length = 255)
    private String emCode;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.EDITOR;

    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private LocalDateTime updatedDate = LocalDateTime.now();

    public Employee() {
    }

    public Employee(LocalDateTime createdDate, String email, String emCode, Long id, String password, Role role, LocalDateTime updatedDate, String username) {
        this.createdDate = createdDate;
        this.email = email;
        this.emCode = emCode;
        this.id = id;
        this.password = password;
        this.role = role;
        this.updatedDate = updatedDate;
        this.username = username;
    }

    public Employee(String email, String emCode, String password, Role role, String username) {
        this.email = email;
        this.emCode = emCode;
        this.password = password;
        this.role = role;
        this.username = username;
    }


    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }

    // Thêm các phương thức của UserDetails để Spring Security hoạt động
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Getter & Setter
    public Long getId() { return id; }

    public String getUsername() { return username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEmCode() { return emCode; }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setEmCode(String emCode) {
        this.emCode = emCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public LocalDateTime getUpdatedDate() { return updatedDate; }
}
