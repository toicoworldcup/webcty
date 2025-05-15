package com.example.webcty.repositories;

import com.example.webcty.entities.CompanyService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyServiceRepository extends JpaRepository<CompanyService, Long> {
}