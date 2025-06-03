package com.example.webcty.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class HomeBannerResponse {
    private Long id;
    private String slogan;
    private List<String> imageUrls;
}