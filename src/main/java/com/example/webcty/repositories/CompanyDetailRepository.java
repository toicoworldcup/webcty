package com.example.webcty.repositories;

import com.example.webcty.entities.CompanyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDetailRepository extends JpaRepository<CompanyDetail, Long> {
}