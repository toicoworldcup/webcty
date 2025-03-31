package com.example.webcty.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyHistoryRequest {
    private String title;
    private Integer year;
    private String description;
    private Integer orderIndex;
}
