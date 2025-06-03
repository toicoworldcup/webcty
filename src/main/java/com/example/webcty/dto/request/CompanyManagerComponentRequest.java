package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyManagerComponentRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Position is required")
    private String position;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Image is required")
    private String image;

    private int orderIndex;
}
