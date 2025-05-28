package com.example.webcty.repositories;

import com.example.webcty.entities.homePage.WhyChooseUs;
import com.example.webcty.entities.homePage.WhyChooseUsComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhyChooseUsComponentRepository extends JpaRepository<WhyChooseUsComponent, Long> {
}