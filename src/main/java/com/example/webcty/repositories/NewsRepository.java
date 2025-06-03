package com.example.webcty.repositories;

import com.example.webcty.entities.newsPage.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllByOrderByOrderIndexAsc();

    @Query("SELECT MAX(n.orderIndex) FROM News n")
    Integer findMaxOrderIndex();
}