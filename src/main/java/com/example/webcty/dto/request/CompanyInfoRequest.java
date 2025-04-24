package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CompanyInfoRequest {
    @NotBlank(message = "SiteName is required")
    private String siteName;

    @NotBlank(message = "SiteDescription is required")
    private String siteDescription;

    @NotBlank(message = "Icon is required")
    private String icon;

    @NotBlank(message = "Director is required")
    private String director;

    @NotNull(message = "Year is required")
    private int year;

    @NotBlank(message = "ContactEmail is required")
    private String contactEmail;

    @NotBlank(message = "ContactPhone is required")
    private String contactPhone;

    @NotBlank(message = "ContactAddress is required")
    private String contactAddress;

    @NotBlank(message = "WorkingHours is required")
    private String workingHours;

    @NotBlank(message = "MapUrl is required")
    private String mapUrl;
}
