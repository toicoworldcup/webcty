package com.example.webcty.repositories;

import com.example.webcty.entities.CompanyExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyExperienceRepository extends JpaRepository<CompanyExperience, Long> {
}