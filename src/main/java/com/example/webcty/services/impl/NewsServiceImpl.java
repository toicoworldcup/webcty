package com.example.webcty.services.impl;

import com.example.webcty.dto.request.NewsRequest;
import com.example.webcty.dto.response.NewsResponse;
import com.example.webcty.entities.News;
import com.example.webcty.repositories.NewsRepository;
import com.example.webcty.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    private NewsResponse convertToResponse(News news) {
        NewsResponse response = new NewsResponse();
        response.setId(news.getId());
        response.setTitle(news.getTitle());
        response.setContent(news.getContent());
        response.setSlug(news.getSlug());
        return response;
    }

    private News convertToEntity(NewsRequest request) {
        News news = new News();
        news.setTitle(request.getTitle());
        news.setContent(request.getContent());
        news.setSlug(request.getSlug());
        return news;
    }

    @Override
    public List<NewsResponse> getAllNews() {
        return newsRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public NewsResponse getNewsById(Long id) {
        return newsRepository.findById(id).map(this::convertToResponse).orElseThrow(() -> new RuntimeException("News not found"));
    }

    @Override
    public NewsResponse createNews(NewsRequest request) {
        News newNews = convertToEntity(request);
        News savedNews = newsRepository.save(newNews);
        return convertToResponse(savedNews);
    }

    @Override
    public NewsResponse updateNews(Long id, NewsRequest request) {
        News existingNews = newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found"));

        existingNews.setTitle(request.getTitle());
        existingNews.setContent(request.getContent());
        existingNews.setSlug(request.getSlug());

        News updatednews = newsRepository.save(existingNews);
        return convertToResponse(updatednews);
    }

    @Override
    public void deleteNews(Long id) {
        if (!newsRepository.existsById(id)) {
            throw new RuntimeException("News not found");
        }
        newsRepository.deleteById(id);
    }
}