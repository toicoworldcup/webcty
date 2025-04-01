package com.example.webcty.repositories;

import com.example.webcty.entities.MediaFile;
import com.example.webcty.enums.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MediaFileRepository extends JpaRepository<MediaFile, Long> {
    List<MediaFile> findByEntityType(MediaType entityType);
    Optional<MediaFile> findByEntityTypeAndEntityId(MediaType entityType, Long entityId);
}
