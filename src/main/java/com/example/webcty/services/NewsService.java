package com.example.webcty.services;

import com.example.webcty.dto.request.NewsRequest;
import com.example.webcty.dto.request.ReorderRequest;
import com.example.webcty.dto.response.NewsResponse;

import java.util.List;

public interface NewsService {
    List<NewsResponse> getAllNews();

    NewsResponse getNewsById(Long id);

    NewsResponse createNews(NewsRequest news);

    NewsResponse updateNews(Long id, NewsRequest updatedNews);

    void deleteNews(Long id);

    void reorderNews(List<ReorderRequest> reorderList);
}
