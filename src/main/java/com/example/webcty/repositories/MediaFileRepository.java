package com.example.webcty.repositories;

import com.example.webcty.entities.MediaFile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaFileRepository extends JpaRepository<MediaFile, Long> {
    List<MediaFile> findByEntityType(String entityType);
    List<MediaFile> findByEntityId(Long entityId);
}