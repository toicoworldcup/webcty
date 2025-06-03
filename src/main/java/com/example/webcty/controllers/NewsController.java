package com.example.webcty.controllers;

import com.example.webcty.dto.request.NewsRequest;
import com.example.webcty.dto.request.ReorderRequest;
import com.example.webcty.dto.response.NewsResponse;
import com.example.webcty.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<List<NewsResponse>> getAllNews() {
        return ResponseEntity.ok(newsService.getAllNews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsResponse> getNewsById(@PathVariable Long id) {
        return ResponseEntity.ok(newsService.getNewsById(id));
    }

    @PostMapping
    public ResponseEntity<NewsResponse> createNews(@RequestBody NewsRequest news) {
        return ResponseEntity.ok(newsService.createNews(news));
    }

    @PutMapping("/reorder")
    public ResponseEntity<Void> reorderNews(@RequestBody List<ReorderRequest> reorderList) {
        newsService.reorderNews(reorderList);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsResponse> updateNews(@PathVariable Long id, @RequestBody NewsRequest updateNews) {
        return ResponseEntity.ok(newsService.updateNews(id, updateNews));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
        return ResponseEntity.noContent().build();
    }
}