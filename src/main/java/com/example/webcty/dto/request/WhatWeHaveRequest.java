package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WhatWeHaveRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;
}
