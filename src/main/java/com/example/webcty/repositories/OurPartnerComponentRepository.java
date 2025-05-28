package com.example.webcty.repositories;

import com.example.webcty.entities.homePage.OurPartnerComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OurPartnerComponentRepository extends JpaRepository<OurPartnerComponent, Long> {
}