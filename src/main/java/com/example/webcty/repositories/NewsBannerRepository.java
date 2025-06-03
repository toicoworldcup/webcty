package com.example.webcty.repositories;

import com.example.webcty.entities.newsPage.NewsBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsBannerRepository extends JpaRepository<NewsBanner, Long> {
}