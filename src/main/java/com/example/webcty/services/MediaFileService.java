package com.example.webcty.services;

import com.example.webcty.entities.MediaFile;
import com.example.webcty.repositories.MediaFileRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MediaFileService {
    private final MediaFileRepository mediaFileRepository;

    public MediaFileService(MediaFileRepository mediaFileRepository) {
        this.mediaFileRepository = mediaFileRepository;
    }

    public List<MediaFile> getAllMediaFiles() {
        return mediaFileRepository.findAll();
    }

    public List<MediaFile> getMediaByEntityType(String entityType) {
        return mediaFileRepository.findByEntityType(entityType);
    }

    public List<MediaFile> getMediaByEntityId(Long entityId) {
        return mediaFileRepository.findByEntityId(entityId);
    }

    public MediaFile saveMediaFile(MediaFile mediaFile) {
        return mediaFileRepository.save(mediaFile);
    }
}