package com.example.webcty.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInfoRequest {
    private String siteName;
    private String siteDescription;
    private String contactEmail;
    private String contactPhone;
    private String contactAddress;
    private String workingHours;
    private String mapEmbedUrl;
}
