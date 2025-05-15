package com.example.webcty.repositories;

import com.example.webcty.entities.CompanySupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanySupportRepository extends JpaRepository<CompanySupport, Long> {
}