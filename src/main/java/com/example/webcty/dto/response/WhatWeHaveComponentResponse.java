package com.example.webcty.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class WhatWeHaveComponentResponse {
    private Long id;
    private String title;
    private String description;
    private String image;
    private List<String> tags;
}
