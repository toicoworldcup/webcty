package com.example.webcty.repositories;

import com.example.webcty.entities.aboutUsPage.CompanyManagerComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyManagerComponentRepository extends JpaRepository<CompanyManagerComponent, Long> {
    List<CompanyManagerComponent> findAllByOrderByOrderIndexAsc();

    @Query("SELECT MAX(n.orderIndex) FROM CompanyManagerComponent n")
    Integer findMaxOrderIndex();
}