package com.example.webcty.repositories;

import com.example.webcty.entities.homePage.HomeIntro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeIntroRepository extends JpaRepository<HomeIntro, Long> {
}