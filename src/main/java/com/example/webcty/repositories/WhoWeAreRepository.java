package com.example.webcty.repositories;

import com.example.webcty.entities.aboutUsPage.WhoWeAre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhoWeAreRepository extends JpaRepository<WhoWeAre, Long> {
}