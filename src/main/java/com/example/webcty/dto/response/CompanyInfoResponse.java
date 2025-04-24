package com.example.webcty.dto.response;

import lombok.Data;

@Data
public class CompanyInfoResponse {
    private Long id;
    private String siteName;
    private String siteDescription;
    private String icon;
    private String director;
    private int year;
    private String contactEmail;
    private String contactPhone;
    private String contactAddress;
    private String workingHours;
    private String mapUrl;
}
