package com.example.webcty.dto.response;

import com.example.webcty.enums.Role;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String emCode;
    private Role role;
}