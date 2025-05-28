package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class HomeBannerRequest {
    @NotBlank(message = "Slogan is required")
    private String slogan;

    @NotNull(message = "ImageUrls is required")
    private List<String> imageUrls;
}
