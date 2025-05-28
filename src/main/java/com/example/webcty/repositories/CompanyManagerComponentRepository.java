package com.example.webcty.repositories;

import com.example.webcty.entities.aboutUsPage.CompanyManagerComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyManagerComponentRepository extends JpaRepository<CompanyManagerComponent, Long> {
}