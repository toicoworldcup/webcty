package com.example.webcty.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer year; // Năm diễn ra sự kiện

    @Column(nullable = false, length = 255)
    private String title; // Tiêu đề sự kiện

    @Column(columnDefinition = "TEXT")
    private String description; // Mô tả chi tiết

    @OneToMany(mappedBy = "companyHistory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MediaFile> images = new ArrayList<>(); // Một công ty có nhiều ảnh

    private Integer orderIndex; // Thứ tự hiển thị (ưu tiên sự kiện gần nhất)

    private Integer modifiedBy; // ID người sửa cuối

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
