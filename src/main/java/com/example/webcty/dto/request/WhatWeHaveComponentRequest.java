package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class WhatWeHaveComponentRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Image is required")
    private String image;

    @NotNull(message = "Tags is required")
    private List<String> tags;
}
