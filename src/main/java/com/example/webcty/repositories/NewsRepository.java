package com.example.webcty.repositories;

import com.example.webcty.entities.newsPage.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    News findByOrderIndex(Integer orderIndex);
    List<News> findByOrderIndexNotOrOrderIndexIsNullOrderByCreatedDateDesc(Integer orderIndex);
}