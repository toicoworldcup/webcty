package com.example.webcty.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private String username;
    private String password;
}
