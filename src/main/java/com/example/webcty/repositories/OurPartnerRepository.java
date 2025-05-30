package com.example.webcty.repositories;

import com.example.webcty.entities.homePage.OurPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OurPartnerRepository extends JpaRepository<OurPartner, Long> {
}