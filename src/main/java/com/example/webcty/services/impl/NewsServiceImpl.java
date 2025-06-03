package com.example.webcty.services.impl;

import com.example.webcty.dto.request.NewsRequest;
import com.example.webcty.dto.request.ReorderRequest;
import com.example.webcty.dto.response.NewsResponse;
import com.example.webcty.entities.newsPage.News;
import com.example.webcty.mapper.NewsMapper;
import com.example.webcty.repositories.NewsRepository;
import com.example.webcty.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
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
        return newsRepository.findAllByOrderByOrderIndexAsc().stream()
                .map(newsMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NewsResponse getNewsById(Long id) {
        News news = newsRepository.findById(id).orElse(null);
        return news != null ? newsMapper.toResponseDTO(news) : null;
    }

    @Override
    @Transactional
    public NewsResponse createNews(NewsRequest newsDTO) {
        News news = newsMapper.toEntity(newsDTO);

        Integer maxOrder = newsRepository.findMaxOrderIndex();
        int nextOrder = (maxOrder != null ? maxOrder : 0) + 1;

        news.setOrderIndex(nextOrder);

        News savedNews = newsRepository.save(news);
        return newsMapper.toResponseDTO(savedNews);
    }

    @Override
    public NewsResponse updateNews(Long id, NewsRequest updatedNewsDTO) {
        News news = newsRepository.findById(id).orElse(null);
        if (news != null) {
            news.setTitle(updatedNewsDTO.getTitle());
            news.setDescription(updatedNewsDTO.getDescription());
            news.setContent(updatedNewsDTO.getContent());
            news.setImage(updatedNewsDTO.getImage());
            News updatedNews = newsRepository.save(news);
            return newsMapper.toResponseDTO(updatedNews);
        }
        return null;
    }

    @Override
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void reorderNews(List<ReorderRequest> reorderList) {
        List<Long> ids = reorderList.stream()
                .map(ReorderRequest::getId)
                .collect(Collectors.toList());

        List<News> newsList = newsRepository.findAllById(ids);

        int tempIndex = -1;
        for (News news : newsList) {
            news.setOrderIndex(tempIndex--);
        }
        newsRepository.saveAll(newsList);
        newsRepository.flush();

        Map<Long, News> newsMap = newsList.stream()
                .collect(Collectors.toMap(News::getId, n -> n));
        int index = 1;
        for (Long id : ids) {
            News news = newsMap.get(id);
            if (news != null) {
                news.setOrderIndex(index++);
            }
        }
        newsRepository.saveAll(newsList);
        newsRepository.flush();
    }
}
