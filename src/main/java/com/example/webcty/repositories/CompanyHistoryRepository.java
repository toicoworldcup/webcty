package com.example.webcty.repositories;

import com.example.webcty.entities.CompanyHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyHistoryRepository extends JpaRepository<CompanyHistory, Long> {
}