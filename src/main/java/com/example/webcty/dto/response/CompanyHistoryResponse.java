package com.example.webcty.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyHistoryResponse {
    private Long id;
    private String title;
    private Integer year;
    private String description;
    private Integer orderIndex;
}