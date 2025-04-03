package com.example.webcty.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDetailResponse {
    private Long id;
    private String title;
    private String content;
}
