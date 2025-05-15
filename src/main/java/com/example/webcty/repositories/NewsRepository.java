package com.example.webcty.repositories;

import com.example.webcty.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findTop4ByOrderIndexIsNotNullOrderByOrderIndexAsc();
    List<News> findByOrderIndexIsNullOrderByCreatedDateDesc();
}