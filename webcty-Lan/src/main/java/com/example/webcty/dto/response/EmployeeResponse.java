package com.example.webcty.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String emCode;
    private String username;
    private String email;
    private String role;
}
