package com.example.webcty.entities;

import com.example.webcty.bases.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import com.example.webcty.enums.MediaType;

@Entity
@Table(name = "media_files")
@NoArgsConstructor
@AllArgsConstructor
public class MediaFile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MediaType entityType;

    @Column(nullable = false)
    private Long entityId;

    private String fileName;
    private String filePath;
    private String fileType;
    private Integer fileSize;

    @Column(nullable = false, length = 255)
    private String url;

    public Long getId() { return id; }

    public MediaType getEntityType() { return entityType; }
    public void setEntityType(MediaType entityType) { this.entityType = entityType; }

    public Long getEntityId() { return entityId; }
    public void setEntityId(Long entityId) { this.entityType = entityType; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = this.url; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }

    public Integer getFileSize() { return fileSize; }
    public void setFileSize(Integer fileSize) { this.fileSize = fileSize; }
}