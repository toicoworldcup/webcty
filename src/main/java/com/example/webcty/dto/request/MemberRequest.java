package com.example.webcty.dto.request;

import com.example.webcty.enums.MemberRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberRequest {
    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "EmCode is required")
    private String emCode;

    @NotBlank(message = "Password is required")
    private String password;

    @NotNull(message = "Role is required")
    private MemberRole role;
}
