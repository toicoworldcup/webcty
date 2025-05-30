package com.example.webcty.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ProjectResponse {
    private Long id;
    private String title;
    private String description;
}