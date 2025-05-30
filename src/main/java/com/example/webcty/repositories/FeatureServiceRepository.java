package com.example.webcty.repositories;

import com.example.webcty.entities.servicePage.FeatureService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureServiceRepository extends JpaRepository<FeatureService, Long> {
}