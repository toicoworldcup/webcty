package com.example.webcty.dto.request;

import com.example.webcty.enums.ContactStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerContactRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotBlank(message = "Message is required")
    private String message;

    @NotNull(message = "Status is required")
    private ContactStatus status;
}
