package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OurPartnerComponentRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Logo is required")
    private String logo;
}
