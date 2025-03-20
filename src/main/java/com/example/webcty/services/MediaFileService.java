package com.example.webcty.services;

import com.example.webcty.entities.MediaFile;
import com.example.webcty.enums.MediaType;

import java.util.List;

public interface MediaFileService {
    List<MediaFile> getAllMediaFiles();

    List<MediaFile> getByEntityType(MediaType entityType);

    MediaFile getByEntityTypeAndEntityId(MediaType entityType, Long entityId);

    MediaFile createMediaFile(MediaFile mediaFile);

    void deleteMediaFile(Long id);
}
