package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class WhyChooseUsComponentRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Icon is required")
    private String icon;

    @NotBlank(message = "ID WhyChooseUs không được để trống")
    @Positive(message = "ID WhyChooseUs phải là số dương")
    private Long whyChooseUsId;
}
