package com.example.webcty.repositories;

import com.example.webcty.entities.CompanyPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyPartnerRepository extends JpaRepository<CompanyPartner, Long> {
}