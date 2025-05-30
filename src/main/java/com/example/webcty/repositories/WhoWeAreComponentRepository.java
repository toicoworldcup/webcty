package com.example.webcty.repositories;

import com.example.webcty.entities.aboutUsPage.WhoWeAreComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhoWeAreComponentRepository extends JpaRepository<WhoWeAreComponent, Long> {
}