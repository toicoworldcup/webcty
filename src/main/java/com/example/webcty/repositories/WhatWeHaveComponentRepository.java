package com.example.webcty.repositories;

import com.example.webcty.entities.homePage.WhatWeHaveComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhatWeHaveComponentRepository extends JpaRepository<WhatWeHaveComponent, Long> {
}