package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OurPartnerComponentRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Logo is required")
    private String logo;

    @NotBlank(message = "ID OurPartnerId không được để trống")
    @Positive(message = "ID OurPartnerId phải là số dương")
    private Long ourPartnerId;
}
