package com.example.webcty.repositories;

import com.example.webcty.entities.aboutUsPage.CompanyManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyManagerRepository extends JpaRepository<CompanyManager, Long> {
}