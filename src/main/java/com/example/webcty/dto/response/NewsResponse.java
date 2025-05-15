package com.example.webcty.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewsResponse {
    private Long id;
    private String title;
    private String description;
    private String content;
    private String image;
    private Integer orderIndex;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
