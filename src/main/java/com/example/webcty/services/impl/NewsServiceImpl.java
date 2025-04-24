package com.example.webcty.services.impl;

import com.example.webcty.dto.request.NewsRequest;
import com.example.webcty.dto.response.NewsResponse;
import com.example.webcty.entities.News;
import com.example.webcty.mapper.NewsMapper;
import com.example.webcty.repositories.NewsRepository;
import com.example.webcty.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
        this.newsMapper = new NewsMapper();
    }

    @Override
    public List<NewsResponse> getAllNews() {
        return newsRepository.findAll().stream()
                .map(newsMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NewsResponse getNewsById(Long id) {
        News news = newsRepository.findById(id).orElse(null);
        return news != null ? newsMapper.toResponseDTO(news) : null;
    }

    @Override
    public NewsResponse createNews(NewsRequest newsDTO) {
        News news = newsMapper.toEntity(newsDTO);
        News savedNews = newsRepository.save(news);
        return newsMapper.toResponseDTO(savedNews);
    }

    @Override
    public NewsResponse updateNews(Long id, NewsRequest updatednewsDTO) {
        News news = newsRepository.findById(id).orElse(null);
        if (news != null) {
            news.setTitle(updatednewsDTO.getTitle());
            news.setDescription(updatednewsDTO.getDescription());
            news.setImage(updatednewsDTO.getImage());
            News updatedNews = newsRepository.save(news);
            return newsMapper.toResponseDTO(updatedNews);
        }
        return null;
    }

    @Override
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}
