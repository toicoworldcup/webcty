package com.example.webcty.repositories;

import com.example.webcty.entities.homePage.WhyChooseUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhyChooseUsRepository extends JpaRepository<WhyChooseUs, Long> {
}