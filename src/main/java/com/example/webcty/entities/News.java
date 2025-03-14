package com.example.webcty.entities;

import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "news")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String title; // Tiêu đề

    @Column(columnDefinition = "TEXT")
    private String content; // Nội dung tin tức

    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MediaFile> mediaFiles = new ArrayList<>(); // Một công ty có nhiều ảnh


    private LocalDateTime publishedAt; // Ngày xuất bản

    private Integer modifiedBy;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.publishedAt = LocalDateTime.now();
    }
}
