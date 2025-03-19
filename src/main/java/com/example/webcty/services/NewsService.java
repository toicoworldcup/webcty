package com.example.webcty.services;

import com.example.webcty.entities.News;

import java.util.List;

public interface NewsService {
    List<News> getAllNews();

    News getNewsById(Long id);

    News createNews(News news);

    News updateNews(Long id, News updatedNews);

    void deleteNews(Long id);
}
