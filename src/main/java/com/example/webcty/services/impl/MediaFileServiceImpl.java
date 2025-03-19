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
    public MediaFile updateMediaFile(MediaType entityType, Long entityId, MediaFile updatedMediaFile) {
        MediaFile mediaFile = getByEntityTypeAndEntityId(entityType, entityId);
        mediaFile.setEntityType(updatedMediaFile.getEntityType());
        mediaFile.setEntityId(updatedMediaFile.getEntityId());
        mediaFile.setUrl(updatedMediaFile.getUrl());
        mediaFile.setFileName(updatedMediaFile.getFileName());
        mediaFile.setFilePath(updatedMediaFile.getFilePath());
        mediaFile.setFileType(updatedMediaFile.getFileType());
        mediaFile.setFileSize(updatedMediaFile.getFileSize());
        return mediaFileRepository.save(mediaFile);
    }

    @Override
    public void deleteMediaFile(Long id) {
        mediaFileRepository.deleteById(id);
    }
}