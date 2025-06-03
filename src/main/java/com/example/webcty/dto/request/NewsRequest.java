package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NewsRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Content is required")
    private String content;

    @NotBlank(message = "Image is required")
    private String image;
}
