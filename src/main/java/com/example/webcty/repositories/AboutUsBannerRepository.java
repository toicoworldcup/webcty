package com.example.webcty.repositories;

import com.example.webcty.entities.aboutUsPage.AboutUsBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUsBannerRepository extends JpaRepository<AboutUsBanner, Long> {
}