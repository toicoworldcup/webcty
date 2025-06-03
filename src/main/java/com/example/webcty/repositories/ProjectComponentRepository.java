package com.example.webcty.repositories;

import com.example.webcty.entities.projectPage.ProjectComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectComponentRepository extends JpaRepository<ProjectComponent, Long> {
    List<ProjectComponent> findAllByOrderByCreatedDateDesc();
}