package com.example.webcty.controllers;

import com.example.webcty.entities.MediaFile;
import com.example.webcty.enums.MediaType;
import com.example.webcty.services.MediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<List<MediaFile>> getAllMediaFiles() {
        return ResponseEntity.ok(mediaFileService.getAllMediaFiles());
    }

    @GetMapping("/type/{entityType}")
    public ResponseEntity<List<MediaFile>> getByEntityType(@PathVariable MediaType entityType) {
        return ResponseEntity.ok(mediaFileService.getByEntityType(entityType));
    }

    @GetMapping("/type/{entityType}/{entityId}")
    public ResponseEntity<MediaFile> getByEntityTypeAndEntityId(@PathVariable MediaType entityType, @PathVariable Long entityId) {
        return ResponseEntity.ok(mediaFileService.getByEntityTypeAndEntityId(entityType, entityId));
    }

    @PostMapping
    public ResponseEntity<MediaFile> createMediaFile(@RequestBody MediaFile mediaFile) {
        return ResponseEntity.ok(mediaFileService.createMediaFile(mediaFile));
    }

    @PutMapping("/{entityType}/{entityId}")
    public ResponseEntity<MediaFile> updateMediaFile(@PathVariable MediaType entityType, @PathVariable Long entityId, @RequestBody MediaFile updatedMediaFile) {
        return ResponseEntity.ok(mediaFileService.updateMediaFile(entityType, entityId, updatedMediaFile));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMediaFile(@PathVariable Long id) {
        mediaFileService.deleteMediaFile(id);
        return ResponseEntity.noContent().build();
    }
}