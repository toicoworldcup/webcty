package com.example.webcty.dto.response;

import lombok.Data;

@Data
public class NewsResponse {
    private Long id;
    private String title;
    private String description;
    private String image;
}
