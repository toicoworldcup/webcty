package com.example.webcty.controllers;

import com.example.webcty.dto.request.MediaFileRequest;
import com.example.webcty.dto.response.MediaFileResponse;
import com.example.webcty.enums.MediaType;
import com.example.webcty.services.MediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media-files")
public class MediaFileController {
    private final MediaFileService mediaFileService;

    @Autowired
    public  MediaFileController(MediaFileService mediaFileService) {
        this.mediaFileService = mediaFileService;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @GetMapping
    public ResponseEntity<List<MediaFileResponse>> getAllMediaFiles() {
        return ResponseEntity.ok(mediaFileService.getAllMediaFiles());
    }

    @GetMapping("/type/{entityType}")
    public ResponseEntity<List<MediaFileResponse>> getByEntityType(@PathVariable MediaType entityType) {
        return ResponseEntity.ok(mediaFileService.getMediaFileByEntityType(entityType));
    }

    @GetMapping("/type/{entityType}/{entityId}")
    public ResponseEntity<MediaFileResponse> getByEntityTypeAndEntityId(@PathVariable MediaType entityType, @PathVariable Long entityId) {
        return ResponseEntity.ok(mediaFileService.getMediaFileByEntityTypeAndEntityId(entityType, entityId));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PostMapping
    public ResponseEntity<MediaFileResponse> createMediaFile(@RequestBody MediaFileRequest request) {
        return ResponseEntity.ok(mediaFileService.createMediaFile(request));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMediaFile(@PathVariable Long id) {
        mediaFileService.deleteMediaFile(id);
        return ResponseEntity.noContent().build();
    }
}