package com.example.webcty.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDetailRequest {
    private String title;
    private String content;
}
