package com.example.webcty.repositories;

import com.example.webcty.entities.servicePage.FeatureServiceComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureServiceComponentRepository extends JpaRepository<FeatureServiceComponent, Long> {
}