package com.example.webcty.services.impl;

import com.example.webcty.entities.MediaFile;
import com.example.webcty.enums.MediaType;
import com.example.webcty.repositories.MediaFileRepository;
import com.example.webcty.services.MediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaFileServiceImpl implements MediaFileService {
    @Autowired
    private MediaFileRepository mediaFileRepository;

    @Override
    public List<MediaFile> getAllMediaFiles() {
        return mediaFileRepository.findAll();
    }

    @Override
    public List<MediaFile> getByEntityType(MediaType entityType) {
        return mediaFileRepository.findByEntityType(entityType);
    }

    @Override
    public MediaFile getByEntityTypeAndEntityId(MediaType entityType, Long entityId) {
        return mediaFileRepository.findByEntityTypeAndEntityId(entityType, entityId);
    }

    @Override
    public MediaFile createMediaFile(MediaFile mediaFile) {
        return mediaFileRepository.save(mediaFile);
    }

    @Override
    public void deleteMediaFile(Long id) {
        mediaFileRepository.deleteById(id);
    }
}