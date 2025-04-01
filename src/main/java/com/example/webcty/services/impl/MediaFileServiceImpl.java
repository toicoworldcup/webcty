package com.example.webcty.services.impl;

import com.example.webcty.dto.request.MediaFileRequest;
import com.example.webcty.dto.response.MediaFileResponse;
import com.example.webcty.entities.MediaFile;
import com.example.webcty.enums.MediaType;
import com.example.webcty.repositories.MediaFileRepository;
import com.example.webcty.services.MediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MediaFileServiceImpl implements MediaFileService {
    private final MediaFileRepository mediaFileRepository;

    @Autowired
    public MediaFileServiceImpl(MediaFileRepository mediaFileRepository) {
        this.mediaFileRepository = mediaFileRepository;
    }

    private MediaFileResponse convertToResponse(MediaFile mediaFile) {
        MediaFileResponse response = new MediaFileResponse();
        response.setId(mediaFile.getId());
        response.setEntityType(mediaFile.getEntityType());
        response.setEntityId(mediaFile.getEntityId());
        response.setFileName(mediaFile.getFileName());
        response.setFilePath(mediaFile.getFilePath());
        response.setFileType(mediaFile.getFileType());
        response.setFileSize(mediaFile.getFileSize());
        response.setUrl(mediaFile.getUrl());
        return response;
    }

    private MediaFile convertToEntity(MediaFileRequest request) {
        MediaFile mediaFile = new MediaFile();
        mediaFile.setEntityType(request.getEntityType());
        mediaFile.setEntityId(request.getEntityId());
        mediaFile.setFileName(request.getFileName());
        mediaFile.setFilePath(request.getFilePath());
        mediaFile.setFileType(request.getFileType());
        mediaFile.setFileSize(request.getFileSize());
        mediaFile.setUrl(request.getUrl());
        return mediaFile;
    }

    @Override
    public List<MediaFileResponse> getAllMediaFiles() {
        return mediaFileRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public List<MediaFileResponse> getMediaFileByEntityType(MediaType entityType) {
        return mediaFileRepository.findByEntityType(entityType).stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public MediaFileResponse getMediaFileByEntityTypeAndEntityId(MediaType entityType, Long entityId) {
        return mediaFileRepository.findByEntityTypeAndEntityId(entityType, entityId).map(this::convertToResponse).orElseThrow(() -> new RuntimeException("MediaFile not found"));
    }

    @Override
    public MediaFileResponse createMediaFile(MediaFileRequest request) {
        MediaFile newMediaFile = convertToEntity(request);
        MediaFile savedMediaFile = mediaFileRepository.save(newMediaFile);
        return convertToResponse(savedMediaFile);
    }

    @Override
    public void deleteMediaFile(Long id) {
        if (!mediaFileRepository.existsById(id)) {
            throw new RuntimeException("MediaFile not found");
        }
        mediaFileRepository.deleteById(id);
    }
}