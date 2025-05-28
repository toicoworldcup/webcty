package com.example.webcty.repositories;

import com.example.webcty.entities.aboutUsPage.AboutUsIntro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUsIntroRepository extends JpaRepository<AboutUsIntro, Long> {
}