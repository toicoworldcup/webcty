package com.example.webcty.dto.response;

import lombok.Data;

@Data
public class HomeIntroResponse {
    private Long id;
    private String title;
    private String description;
    private String content;
    private String image;
}
