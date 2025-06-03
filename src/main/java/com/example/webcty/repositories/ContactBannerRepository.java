package com.example.webcty.repositories;

import com.example.webcty.entities.contactPage.ContactBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactBannerRepository extends JpaRepository<ContactBanner, Long> {
}