package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WhoWeAreComponentRequest {
    @NotBlank(message = "Content is required")
    private String content;
}
