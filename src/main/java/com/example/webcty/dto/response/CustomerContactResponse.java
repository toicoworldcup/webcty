package com.example.webcty.dto.response;

import com.example.webcty.enums.ContactStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerContactResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String message;
    private ContactStatus status;
    private LocalDateTime createdDate;
}
