package com.example.webcty.repositories;

import com.example.webcty.entities.projectPage.ProjectBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectBannerRepository extends JpaRepository<ProjectBanner, Long> {
}