package com.example.webcty.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsResponse {
    private Long id;
    private String title;
    private String content;
    private String slug;
}
