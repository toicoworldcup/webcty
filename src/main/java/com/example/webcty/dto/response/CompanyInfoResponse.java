package com.example.webcty.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInfoResponse {
    private Long id;
    private String siteName;
    private String siteDescription;
    private String contactEmail;
    private String contactPhone;
    private String contactAddress;
    private String workingHours;
    private String mapEmbedUrl;
}
