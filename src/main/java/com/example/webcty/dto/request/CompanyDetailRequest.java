package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyDetailRequest {
    @NotBlank(message = "Name is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;
}
