package com.example.webcty.dto.response;

import lombok.Data;

@Data
public class CompanyManagerComponentResponse {
    private Long id;
    private String name;
    private String position;
    private String description;
    private String image;
    private int orderIndex;
}
