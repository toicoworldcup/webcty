package com.example.webcty.dto.response;

import lombok.Data;

@Data
public class ProjectComponentResponse {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String content;
}