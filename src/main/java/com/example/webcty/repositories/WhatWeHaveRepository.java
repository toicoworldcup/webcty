package com.example.webcty.repositories;

import com.example.webcty.entities.homePage.WhatWeHave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WhatWeHaveRepository extends JpaRepository<WhatWeHave, Long> {
    Optional<WhatWeHave> findTopByOrderByIdAsc();
}