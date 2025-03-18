package com.example.webcty.services;

import com.example.webcty.entities.MediaFile;
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

    public MediaFile saveMediaFile(MediaFile mediaFile) {
        return mediaFileRepository.save(mediaFile);
    }
}