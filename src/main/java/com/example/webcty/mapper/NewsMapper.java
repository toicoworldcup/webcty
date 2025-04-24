package com.example.webcty.mapper;

import com.example.webcty.dto.request.NewsRequest;
import com.example.webcty.dto.response.NewsResponse;
import com.example.webcty.entities.News;
import org.springframework.stereotype.Component;

@Component
public class NewsMapper {
    public News toEntity(NewsRequest dto) {
        News news = new News();
        news.setTitle(dto.getTitle());
        news.setDescription(dto.getDescription());
        news.setImage(dto.getImage());
        news.setCreatedBy("admin"); // Mặc định created_by là admin
        return news;
    }

    public NewsResponse toResponseDTO(News entity) {
        NewsResponse dto = new NewsResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        return dto;
    }
}