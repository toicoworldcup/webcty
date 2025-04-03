package com.example.webcty.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsRequest {
    private String title;
    private String content;
    private String slug;
}
