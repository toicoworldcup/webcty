package com.example.webcty.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class WhoWeAreResponse {
    private Long id;
    private String title;
    private String description;
    private List<String> content;
}
