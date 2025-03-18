package com.example.webcty.controllers;

import com.example.webcty.entities.MediaFile;
import com.example.webcty.enums.MediaType;
import com.example.webcty.services.MediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media-files")
public class MediaFileController {
    @Autowired
    private final MediaFileService mediaFileService;

    public MediaFileController(MediaFileService mediaFileService) {
        this.mediaFileService = mediaFileService;
    }

    @GetMapping
    public List<MediaFile> getAllMediaFiles() {
        return mediaFileService.getAllMediaFiles();
    }

    @GetMapping("/type/{entityType}")
    public List<MediaFile> getByMediaType(@PathVariable MediaType mediaType) {
        return mediaFileService.getByMediaType(mediaType);
    }

    @GetMapping("/entity/{entityType}/{entityId}")
    public MediaFile getByMediaTypeAndTypeId(@PathVariable MediaType entityType, @PathVariable Long entityId) {
        return mediaFileService.getByMediaTypeAndTypeId(entityType, entityId);
    }

    @PostMapping
    public MediaFile uploadMediaFile(@RequestBody MediaFile mediaFile) {
        return mediaFileService.saveMediaFile(mediaFile);
    }
}