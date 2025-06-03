package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ServiceBannerRequest {
    @NotBlank(message = "Slogan is required")
    private String slogan;

    @NotBlank(message = "Image is required")
    private String image;
}
