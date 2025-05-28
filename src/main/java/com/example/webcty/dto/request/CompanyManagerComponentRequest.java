package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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

    @NotBlank(message = "ID CompanyManager không được để trống")
    @Positive(message = "ID CompanyManager phải là số dương")
    private Long companyManagerId;
}
