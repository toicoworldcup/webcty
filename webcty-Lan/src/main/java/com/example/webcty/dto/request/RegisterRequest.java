package com.example.webcty.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String emCode;
    private String username;
    private String email;
    private String password;
    private String role;

}
