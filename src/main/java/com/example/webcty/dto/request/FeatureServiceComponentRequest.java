package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class FeatureServiceComponentRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Image is required")
    private String image;

    @NotBlank(message = "ID FeatureService không được để trống")
    @Positive(message = "ID FeatureService phải là số dương")
    private Long featureServiceId;
}
