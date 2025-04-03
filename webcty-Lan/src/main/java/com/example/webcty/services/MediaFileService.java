package com.example.webcty.services;

import com.example.webcty.dto.request.MediaFileRequest;
import com.example.webcty.dto.response.MediaFileResponse;
import com.example.webcty.enums.MediaType;

import java.util.List;

public interface MediaFileService {
    List<MediaFileResponse> getAllMediaFiles();

    List<MediaFileResponse> getMediaFileByEntityType(MediaType entityType);

    MediaFileResponse getMediaFileByEntityTypeAndEntityId(MediaType entityType, Long entityId);

    MediaFileResponse createMediaFile(MediaFileRequest request);

    void deleteMediaFile(Long id);
}