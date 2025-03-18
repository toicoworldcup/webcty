package com.example.webcty.services;

import com.example.webcty.entities.MediaFile;
import com.example.webcty.entities.Product;
import com.example.webcty.enums.MediaType;
import com.example.webcty.repositories.MediaFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaFileService {
    @Autowired
    private MediaFileRepository mediaFileRepository;

    public List<MediaFile> getAllMediaFiles() {
        return mediaFileRepository.findAll();
    }

    public List<MediaFile> getByMediaType(MediaType mediaType) {
        return mediaFileRepository.findByEntityType(mediaType);
    }

    public MediaFile getByMediaTypeAndTypeId(MediaType mediaType, Long typeId) {
        return mediaFileRepository.findByEntityTypeAndEntityId(mediaType, typeId);
    }

    public MediaFile createMediaFile(MediaFile mediaFile) {
        return mediaFileRepository.save(mediaFile);
    }

    public MediaFile updateMediaFile(MediaType mediaType, Long typeId, MediaFile updatedMediaFile) {
        MediaFile mediaFile = getByMediaTypeAndTypeId(mediaType, typeId);
        mediaFile.setEntityType(updatedMediaFile.getEntityType());
        mediaFile.setEntityId(updatedMediaFile.getEntityId());
        mediaFile.setUrl(updatedMediaFile.getUrl());
        mediaFile.setFileName(updatedMediaFile.getFileName());
        mediaFile.setFilePath(updatedMediaFile.getFilePath());
        mediaFile.setFileType(updatedMediaFile.getFileType());
        mediaFile.setFileSize(updatedMediaFile.getFileSize());
        return mediaFileRepository.save(mediaFile);
    }

    public void deleteMediaFile(Long id) {
        mediaFileRepository.deleteById(id);
    }
}